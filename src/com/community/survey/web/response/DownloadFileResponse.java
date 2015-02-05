package com.community.survey.web.response;

public class DownloadFileResponse {
	
	public byte[] getByteData() {
		return byteData;
	}
	public void setByteData(byte[] byteData) {
		this.byteData = byteData;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	private byte[] byteData;
	private String mimeType;
	private boolean success;
}
