package ar.com.jmvg.challenges.minesweeper.api.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
public abstract class AbstractEntityAuditable implements BaseEntityAuditable {

	private static final long serialVersionUID = 1462334279101368700L;

	@Id
	private Long id;
	private Date creationDate;
	@LastModifiedDate
	private Date modificationDate;
	
	@Override
	public Long getId() {
		return this.id;
	}
	
	@Override
	public Date getCreationDate() {
		return this.creationDate;
	}
	@Override
	public Date getModificationDate() {
		return this.modificationDate;
	}

}
