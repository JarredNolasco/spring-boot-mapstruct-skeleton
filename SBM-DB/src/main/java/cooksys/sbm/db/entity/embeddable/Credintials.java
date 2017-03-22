package cooksys.sbm.db.entity.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Credintials {

	@NotNull
	@Column(unique = true, nullable = false)
	private String username;
	
	@NotNull
	@Column(nullable = false)
	private String password;
	
}
