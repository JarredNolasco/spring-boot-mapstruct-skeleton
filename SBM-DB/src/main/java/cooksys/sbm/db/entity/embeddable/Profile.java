package cooksys.sbm.db.entity.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Profile {

	private String firstname;
	
	private String lastname;
	
	@NotNull
	@Column(unique = true, nullable = false)
	private String email;
	
	private String phonenumber;
	
	
}
