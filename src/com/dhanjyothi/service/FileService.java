package com.dhanjyothi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dhanjyothi.model.FileEntity;

@Service
public interface FileService {

	void saveFileUpload(FileEntity fileEntity);
	List<FileEntity> viewAllFiles();
	List<FileEntity> findByName(String fileName);

}
