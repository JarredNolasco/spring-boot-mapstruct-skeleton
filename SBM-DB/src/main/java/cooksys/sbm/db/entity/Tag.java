package cooksys.sbm.db.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import cooksys.sbm.db.entity.superclass.BaseEntity;

@Entity
@Table (name = "TagTable")
public class Tag implements BaseEntity<Long> {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String label;
	
	private Timestamp firstused;
	
	private Timestamp lastused;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Timestamp getFirstused() {
		return firstused;
	}

	public void setFirstused(Timestamp firstused) {
		this.firstused = firstused;
	}

	public Timestamp getLastused() {
		return lastused;
	}

	public void setLastused(Timestamp lastused) {
		this.lastused = lastused;
	}

	

	

}
