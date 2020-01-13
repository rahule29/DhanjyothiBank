package com.dhanjyothi.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "File")
public class FileEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8926601332139152804L;

	private long fileId;
	private String fileName;
	private byte[] data;
	
	public FileEntity() {
		super();
	}

	public FileEntity(long fileId, String fileName, byte[] data) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.data = data;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FILE_ID", unique = true, nullable = false)
	public long getFileId() {
		return fileId;
	}

	public void setFileId(long id) {
		this.fileId = id;
	}

	@Column(name = "FILE_NAME")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "DATA")
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "FileEntity [id=" + fileId + ", fileName=" + fileName + ", data=" + Arrays.toString(data) + "]";
	}
	
	
}
