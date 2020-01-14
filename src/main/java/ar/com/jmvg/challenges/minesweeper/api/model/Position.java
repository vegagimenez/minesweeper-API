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
	public Boolean isAdjacent(Position pos) {
		return Math.abs(this.x - pos.getX()) <= 1 && Math.abs(this.y - pos.getY()) <= 1;
	}
}
