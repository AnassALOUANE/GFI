package com.sqli.gfi.dao;

import com.sqli.gfi.model.Document;

public interface DocumentDao {

	public void addDocument(Document document);

	public Document getDocumentById(int idD);
	
	public void deleteDocument(int idD);
	
}
