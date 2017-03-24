package cooksys.sbm.dto.dto;

import cooksys.sbm.db.entity.embeddable.Credentials;

public class TweetDto {

	private Credentials credentials;
	
	private String content;

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
