package com.healthcare.dto;



public class Response {



	private String message;
	
	private int statusCode;
	
	private Object data;

	 public Response(String message, int statusCode, Object data) {
	        this.message = message;
	        this.statusCode = statusCode;
	        this.data = data;
	    }

	public Response() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getdata() {
		return data;
	}

	public void setdata(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [message=" + message + ", statusCode=" + statusCode + ", data=" + data + "]";
	}
	 
	 
	 
}
