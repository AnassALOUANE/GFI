package com.sqli.gfi.web;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class SendMailAspectJ {
	
//	private Log log = LogFactory.getLog(this.getClass());

	@After("execution(* InscriptionController.add(..))")
	public void SendMailAfterAfter(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
	    for (int i = 0; i < args.length; i++) {
	        if (args[i] instanceof String && ((String) args[i]).isEmpty()) {
	            args[i] = null;
	        }
	        System.out.println("????????????????? "+args[i]);
	    }
		System.out.println(" ########################################  The method " + joinPoint.getSignature().getName()+ "() begins with : " + Arrays.toString(joinPoint.getArgs()));
	}
	
	
	
}
