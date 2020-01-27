package com.lti.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("response")
@Scope(scopeName="prototype")

public class ResponseMessage {
	
	
	public ResponseMessage() {
		super();
		
	}

	public ResponseMessage(String message){
		this.message = message;
	}
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
