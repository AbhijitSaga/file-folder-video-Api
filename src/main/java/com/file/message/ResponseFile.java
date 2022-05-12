package com.file.message;

public class ResponseFile {
	private String id;
	private String url;
	private byte[] type;
	public ResponseFile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseFile(String id, String url, byte[] bs) {
		super();
		this.id = id;
		this.url = url;
		this.type = bs;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public byte[] getType() {
		return type;
	}
	public void setType(byte[] type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ResponseFile [id=" + id + ", url=" + url + ", type=" + type + "]";
	}
	
	
	
	
}
