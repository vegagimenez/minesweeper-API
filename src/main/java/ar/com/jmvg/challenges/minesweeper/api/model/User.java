package ar.com.jmvg.challenges.minesweeper.api.model;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class User extends AbstractEntityAuditable {

	private static final long serialVersionUID = -4699228895626236940L;
	
	private String email;
	private String password;
	private Long totalPoints;
	@Transient
	private String token;
	
}
