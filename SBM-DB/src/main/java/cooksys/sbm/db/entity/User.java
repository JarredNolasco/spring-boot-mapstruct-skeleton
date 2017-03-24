package cooksys.sbm.db.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.Temporal;

import cooksys.sbm.db.entity.embeddable.Credentials;
import cooksys.sbm.db.entity.embeddable.Profile;
import cooksys.sbm.db.entity.superclass.BaseEntity;



@Entity
@Table (name = "UserTable")

public class User implements BaseEntity<Long> {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Column(name="user_username")
	private String username;

	private Boolean exist;
	
	//@Temporal(TemporalType.TIMESTAMP)
	private Date timecreated;
	
	//@NotNull
	private Credentials credentials;

	private Profile profile;
	
	@ManyToOne
	private User mainprofile;
	
	@ManyToMany
	private Set<User> followers;
	
	@ManyToMany
	private Set<User> following;
	
	@ManyToMany(mappedBy="likedBy")
	private Set<Tweet> likedtweets;
	
	@ManyToMany
	private Set<Tweet> mentionedtweets;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
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

	public Set<User> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}

	public Set<User> getFollowing() {
		return following;
	}

	public void setFollowing(Set<User> following) {
		this.following = following;
	}

	public Set<Tweet> getLikedtweets() {
		return likedtweets;
	}

	public void setLikedtweets(Set<Tweet> likedtweets) {
		this.likedtweets = likedtweets;
	}

	public Set<Tweet> getMentionedtweets() {
		return mentionedtweets;
	}

	public void setMentionedtweets(Set<Tweet> mentionedtweets) {
		this.mentionedtweets = mentionedtweets;
	}

	

}
