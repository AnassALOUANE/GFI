package com.sqli.gfi.web;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sqli.gfi.model.Document;
import com.sqli.gfi.model.Formation;
import com.sqli.gfi.service.DocumentService;
import com.sqli.gfi.service.FormationService;

@Controller
@RequestMapping("/{idF}/document/*")
public class DocumentController /*implements HandlerExceptionResolver*/ {
	
	@Autowired
	private FormationService formationService;
	
	@Autowired
	private DocumentService documentService;
	 
	
	/** lister les  documents d'une formation donnée */
	@RequestMapping(value = "index", method = RequestMethod.GET)
    public String indexDocument(@PathVariable("idF") Integer idF, @ModelAttribute Document document, Model model) {
		
        Formation formation = formationService.getFormationById(idF);
        model.addAttribute("formation", formation); 
        return "index_document";
    }
	
   /** 
	 * ajouter un document
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
    public String addDocument(@PathVariable("idF") Integer idF, @RequestParam("file") CommonsMultipartFile file/*MultipartFile file*/, @Valid @ModelAttribute Document document,  BindingResult result, Model model) {
				
		if(result.hasErrors()) {
			 Formation formation = formationService.getFormationById(idF);
		     model.addAttribute("formation", formation);
			 return "index_document";
		 }
		 			
			if (file != null && file.getSize() > 0) {
	            
				document.setFilename(file.getOriginalFilename());
				document.setContenu(file.getBytes());
				document.setTypeContenu(file.getContentType());
				
				Formation form =  formationService.getFormationById(idF);
				document.setFormation(form);
				documentService.addDocument(document);
	            
	        } else if(file.getSize() == 0){
	        	Formation formation = formationService.getFormationById(idF);
	            model.addAttribute("formation", formation); 
	            model.addAttribute("errorFileEmpty", "vous devez spécifier un document");
	            return "index_document";
	        	
	        }
		 		
		 return "redirect:index";
    }
	
   /** 
	 * modifier un document  
	 */
	@RequestMapping(value = "update/{idD}", method = RequestMethod.GET)
    public String updateDocumentPage(@PathVariable("idD") Integer idD, Model model) {
		Document doc = documentService.getDocumentById(idD);
		Document update_doc = new Document();
		update_doc.setId_doc(doc.getId_doc());
		update_doc.setFormation(doc.getFormation());
		update_doc.setNom(doc.getNom());
		update_doc.setDesc(doc.getDesc());
		model.addAttribute("document", update_doc);
    	return "document_update";
    }
	
	@RequestMapping(value = "update/{idD}", method = RequestMethod.POST)
    public String updateDocument( @Valid @ModelAttribute Document document,  BindingResult result, @PathVariable("idF") Integer idF, @PathVariable("idD") Integer idD, @RequestParam("file") CommonsMultipartFile file, Model model) {
    	if(result.hasErrors()) {
    		model.addAttribute("document", documentService.getDocumentById(idD));
        	return "document_update";	
    	}
    	
		if (file != null && file.getSize() > 0) {
            
			document.setId_doc(idD);
	    	Formation form =  formationService.getFormationById(idF);
			document.setFormation(form);
			document.setFilename(file.getOriginalFilename());
			document.setContenu(file.getBytes());
			document.setTypeContenu(file.getContentType());
			
			System.out.println("######################### ***************** "+document.getId_doc());
			
			documentService.addDocument(document);
            
        } else if(file.getSize() == 0){
        	Document doc = documentService.getDocumentById(idD);
    		Document update_doc = new Document();
    		update_doc.setId_doc(doc.getId_doc());
    		update_doc.setFormation(doc.getFormation());
    		update_doc.setNom(doc.getNom());
    		update_doc.setDesc(doc.getDesc());
    		model.addAttribute("document", update_doc);
    		model.addAttribute("errorFileEmpty", "vous devez spécifier un document");
        	return "document_update";
        	
        }
	
    	
    	return "redirect:/"+idF+"/document/index";
    }

	
	/** telecharger un document */
	@RequestMapping("/download/{documentId}")
	public String download(@PathVariable("documentId")
			Integer documentId, HttpServletResponse response) {
		
		Document doc = documentService.getDocumentById(documentId);
		try {
			response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFilename()+ "\"");
			OutputStream out = response.getOutputStream();
			response.setContentType(doc.getTypeContenu());
			FileCopyUtils.copy(doc.getContenu(), out);
			out.flush();
			out.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		return null;
	}
	
	/** supprimer  un document */
    @RequestMapping(value = "delete/{idD}", method = RequestMethod.GET)
    public String deleteDocument(@PathVariable("idF") Integer idF, @PathVariable("idD") Integer idD) {
    	documentService.deleteDocument(idD);
    	return "redirect:/"+idF+"/document/index";
    }
	
	/** si la tailled e fichier superieur à 10 Mo une exeception est lancé */
	/*
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception) {
		
		 Map<Object, Object> model = new HashMap<Object, Object>();
	        if (exception instanceof MaxUploadSizeExceededException){
	            model.put("errors", "la taille de fichier doit etre moin de  "+ ((MaxUploadSizeExceededException)exception).getMaxUploadSize()+" byte(10Mo).");
	        } else{
	            model.put("errors", "error de chargement de fichier, svp veuillez contacter l'administrateur: " + exception.getMessage());
	        }
	        model.put("document", new Document());
	        return new ModelAndView("/index_document", (Map) model);
	}
	
	*/
	
	

	
}
