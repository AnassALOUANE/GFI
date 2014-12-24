package com.sqli.gfi.service;

import com.sqli.gfi.model.Document;


public interface DocumentService {

	public void addDocument(Document document);

	public Document getDocumentById(int idD);
	
	public void deleteDocument(int idD);
}
