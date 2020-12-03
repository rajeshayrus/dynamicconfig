package com.dynamicconfiguration.excep;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class ExceptionResponse {
	
	private String message;
	private String errorCode;
	private Date date;
	

	public ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}


	public ExceptionResponse(String message, String errorCode, Date date) {
		super();
		this.message = message;
		this.errorCode = errorCode;
		this.date = date;
	}
	
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	

	
	
}
