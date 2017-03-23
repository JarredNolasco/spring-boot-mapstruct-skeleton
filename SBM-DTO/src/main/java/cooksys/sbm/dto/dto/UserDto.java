package cooksys.sbm.dto.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import cooksys.sbm.db.entity.embeddable.Credentials;
import cooksys.sbm.db.entity.embeddable.Profile;
import cooksys.sbm.dto.validation.group.RequiredFieldsNotNull;




public class UserDto {
	

	private Long id;
	
	@NotNull
	@Column(name="user_username")
	private String username;
	
	private Boolean exist;
	
	//@Column
	//private Timestamp joined;
	
	@NotNull 
	private Credentials credentials;
	
	
	private Profile profile;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getExist() {
		return exist;
	}

	public void setExist(Boolean exist) {
		this.exist = exist;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
