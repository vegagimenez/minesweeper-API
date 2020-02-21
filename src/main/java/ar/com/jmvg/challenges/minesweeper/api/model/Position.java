package ar.com.jmvg.challenges.minesweeper.api.model;

import lombok.Data;

@Data
public class Position {

	private Integer x;
	private Integer y;

	public Position(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Checks if this position is adjacent to the position received in the parameter.
	 * */
	public Boolean isAdjacent(Position pos, Difficulty difficulty) {
		
		return (this.x >= 0) && (this.x < difficulty.getRows()) && (this.y >= 0) && (this.y < difficulty.getColumns());
		
	}
}
