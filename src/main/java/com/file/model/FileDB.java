package com.file.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "filesDB")
public class FileDB {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String url;
	private String typeFile;
	
	private String email;

	// private byte[] type;

	/*
	 * @Lob private byte[] data;
	 */

	public FileDB() {
	}

	

	public void setEmail(String email) {
		this.email = email;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getEmail() {
		return email;
	}


	public String getTypeFile() {
		return typeFile;
	}

	public void setTypeFile(String typeFile) {
		this.typeFile = typeFile;
	}

	@Override
	public String toString() {
		return "FileDB [id=" + id + ", url=" + url + ", typeFile=" + typeFile + ", Email=" + email + "]";
	}

	/*
	 * public byte[] getType() { return type; }
	 * 
	 * public void setType(byte[] type) { this.type = type; }
	 */

	/*
	 * public byte[] getData() { return data; }
	 * 
	 * public void setData(byte[] data) { this.data = data; }
	 */

}
