package com.sqli.gfi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sqli.gfi.dao.DocumentDao;
import com.sqli.gfi.model.Document;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentDao documentDao;
	
	 
	public void addDocument(Document document) {
		documentDao.addDocument(document);
	}

	 
	@Transactional(readOnly = true)
	public Document getDocumentById(int idD) {
		return documentDao.getDocumentById(idD);
	}

	 
	public void deleteDocument(int idD) {
		documentDao.deleteDocument(idD);
	}

}
