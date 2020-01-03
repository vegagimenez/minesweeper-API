package ar.com.jmvg.challenges.minesweeper.api.model;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Reference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiObject
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Game extends AbstractEntityAuditable {

	private static final long serialVersionUID = -1525736696141309072L;

	@ApiObjectField(description = "The User related to this Game.")
	@Reference
	private User user;
	
	@ApiObjectField(description = "The Config selected to this Game.")
	private GameConfig config;
	
	@ApiObjectField(description = "The amount of points earned with this Game.")
	private Long points;
	//TODO: Implement GameStatus to tracking.
}
