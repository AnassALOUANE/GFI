package com.sqli.gfi.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.sqli.gfi.model.ResponsableFormation;
import com.sqli.gfi.model.Utilisateur;
import com.sqli.gfi.service.CompteService;
import com.sqli.gfi.service.UtilisateurService;

@Component

public class GFI_UrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	protected Log log = LogFactory.getLog(this.getClass());
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Autowired
	private CompteService compteService;
	@Autowired
	private UtilisateurService utilisateurService;
	
	
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,ServletException {
		handle(request, response, authentication);
        clearAuthenticationAttributes(request);
		// TODO Auto-generated method stub
		
	}
	
	
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		String targetUrl = determineTargetUrl(request, authentication);

		if (response.isCommitted()) {
			log.debug("Response has already been committed. Unable to redirect to " + targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	 /** Determiner la page d'acceuil de l'utilisateur connecte. */
    protected String determineTargetUrl(HttpServletRequest request, Authentication authentication) {
        boolean isResp_f = false;
        boolean isAdmin = false;
        boolean isCollaborateur = false;
        boolean isFormateur = false;
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        /** recuperer le username(login) de l'utilisateur connecte */
        String login = authentication.getName();
        /** recuperer l'Id de l'utilisateur connecte */
	    Integer id_compte = compteService.getIdCompteByLogin(login);
	    Utilisateur user_connecte = (Utilisateur)utilisateurService.getUtilisateurByIdCompte(id_compte);
	    log.info("########################__________ **************______________  "+ user_connecte +"  ____________**********_____________#######################");
	    HttpSession session = request.getSession();
	    
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ROLE_RESP_F")) {
            	isResp_f = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_COL")) {
            	isCollaborateur = true;
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_FOR")) {
            	isFormateur = true;
                break;
            }
        }
        
             
        if (isResp_f) {
        	/** ajouter le responsable connecté dans la @session */
        	 
        	ResponsableFormation resp_f_connecte = (ResponsableFormation) user_connecte;
        	session.setAttribute("resp_f_connecte", resp_f_connecte);
        	session.setAttribute("user", resp_f_connecte.getNom()+" "+resp_f_connecte.getPrenom());            
        	return "/formation/index"; /** rediriger le responsable de formation vers la page d'accueil de responsables de formation*/
        	
        } else if (isAdmin) {
        	
        	session.setAttribute("user_connecte", user_connecte);
        	session.setAttribute("user", user_connecte.getNom()+" "+user_connecte.getPrenom());        	
            return "/users/c/index";  /** rediriger l'admin vers la page d'accueil d'administration*/
        } else if (isCollaborateur) {
        	
        	
            return "/welcome/index"; /** rediriger l'admin vers la page d'accueil de collaborateurs */
        } else if (isFormateur) {
        	session.setAttribute("user_connecte", user_connecte);
        	session.setAttribute("user", user_connecte.getNom()+" "+user_connecte.getPrenom()); 
            return "/"+ user_connecte.getId_u() +"/absence/index"; /** rediriger l'admin vers la page d'accueil formateurs*/
        } else {
            throw new IllegalStateException();
        }
    }
    
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
    	HttpSession session = request.getSession(false);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
	

}
