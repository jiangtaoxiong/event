package com.guangeryi.event.entity;

import java.io.Serializable;

public class Email implements Serializable{
	
	private String sender;
	
	private String reciver;
	
	private String title;
	
	private String content;

	public Email(String sender, String reciver, String title, String content) {
		super();
		this.sender = sender;
		this.reciver = reciver;
		this.title = title;
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciver() {
		return reciver;
	}

	public void setReciver(String reciver) {
		this.reciver = reciver;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
	
	

}
