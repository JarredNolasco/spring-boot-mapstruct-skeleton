package cooksys.sbm.db.entity;

import java.security.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cooksys.sbm.db.entity.superclass.BaseEntity;



@Entity
@Table (name = "TweetTable")
public class Tweet implements BaseEntity<Long>{

	@Id
	@GeneratedValue
	private long id;
	
	private String username;
	
	private Timestamp postedtime;
	
	private String content;
	
	private Boolean exist;
	
	@OneToMany(mappedBy = "original")
	private Set<Tweet> replies;
	
	@ManyToOne 
	private Tweet original;
	
	@OneToMany(mappedBy = "repostOriginal")
	private Set<Tweet> repostof;
	
	@ManyToOne
	private Tweet repostOriginal;
	
	@ManyToMany
	private Set<User> likedBy;

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

	public Timestamp getPostedtime() {
		return postedtime;
	}

	public void setPostedtime(Timestamp postedtime) {
		this.postedtime = postedtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<User> getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(Set<User> likedBy) {
		this.likedBy = likedBy;
	}

	public Boolean getExist() {
		return exist;
	}

	public void setExist(Boolean exist) {
		this.exist = exist;
	}
	
	
}
