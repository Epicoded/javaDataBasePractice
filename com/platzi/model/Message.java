package com.platzi.model;

/**
*
* @author EpicGex
*/

public class Message {
	private int idMessage;
	private String message;
	private String messageAuthor;
	private String messageDatetime;
	
	public Message() {
		
	}

	
	public Message(String message, String messageAuthor, String messageDatetime) {
		this.message = message;
		this.messageAuthor = messageAuthor;
		this.messageDatetime = messageDatetime;
	}
	
	public int getIdMessage() {
		return idMessage;
	}
	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageAuthor() {
		return messageAuthor;
	}
	public void setMessageAuthor(String messageAuthor) {
		this.messageAuthor = messageAuthor;
	}
	public String getMessageDatetime() {
		return messageDatetime;
	}
	public void setMessageDatetime(String messageDatetime) {
		this.messageDatetime = messageDatetime;
	}
	
	
}
