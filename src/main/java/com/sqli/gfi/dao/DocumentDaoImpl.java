package com.sqli.gfi.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.sqli.gfi.model.Document;

@Repository
public class DocumentDaoImpl implements DocumentDao {

	@PersistenceContext
	private EntityManager em;
	
	 
	public void addDocument(Document document) {
		em.merge(document);
		em.flush();
		
	}

	 
	public Document getDocumentById(int idD) {
		return em.find(Document.class, idD);
	}

	 
	public void deleteDocument(int idD) {
		Document doc_from_db = getDocumentById(idD);
		if(doc_from_db != null) {
			em.remove(doc_from_db);
			em.flush();
		}
	}

}
