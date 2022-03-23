package com.javabrains.messenger.model;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String errorMsg;
	private int errCode;
	private String document;
	
	public ErrorMessage() {		
	}	
	
	public ErrorMessage(String errorMsg, int errCode, String document) {
		super();
		this.errorMsg = errorMsg;
		this.errCode = errCode;
		this.document = document;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public int getErrCode() {
		return errCode;
	}
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
	public String getDocument() {
		return document;
	}
	public void setDocument(String document) {
		this.document = document;
	}
	
	
	
}
