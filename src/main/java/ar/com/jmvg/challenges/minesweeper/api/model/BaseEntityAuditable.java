package ar.com.jmvg.challenges.minesweeper.api.model;

import java.io.Serializable;
import java.util.Date;

public interface BaseEntityAuditable extends Serializable{

	public Long getId();
	public Date getCreationDate();
	public Date getModificationDate();
	//TODO: 'cause I'm saying "Auditable" I should implement a User responsible of any changes.
}
