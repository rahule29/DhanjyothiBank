package com.dhanjyothi.dao;


import java.util.List;
import com.dhanjyothi.model.FileEntity;

public interface FileDao {

	void saveFileUpload(FileEntity fileEntity);	
	
	List<FileEntity> viewAllFiles();	
	
	List<FileEntity> findByName(String fileName);	

}
