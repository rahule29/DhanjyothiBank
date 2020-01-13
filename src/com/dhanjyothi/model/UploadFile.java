/**
 * 
 */
package com.dhanjyothi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

/**
 * @author RBADIGER
 *
 */
@Entity
@Table(name = "UPLOAD_FILE")
public class UploadFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7214546756106909029L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FILE_ID", unique = true, nullable = false)
	private int fileId;
	
	@Column(name = "FILE")
	@Lob
	private byte[] file;

	public UploadFile(byte[] file) {
		super();
		this.file = file;
	}

	public UploadFile() {
		super();
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "UploadFile [file=" + file + "]";
	}
	
}
