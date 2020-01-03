package ar.com.jmvg.challenges.minesweeper.api.model;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;

import lombok.Data;

/**
 * This class is a representation of the board configuration
 * I'll implement only 3 levels of difficulty to reduce complexity.
 * */
@Data
@Entity
public class GameConfig {

	private Difficulty difficulty;

}
