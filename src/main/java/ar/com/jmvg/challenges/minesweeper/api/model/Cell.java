package ar.com.jmvg.challenges.minesweeper.api.model;

import java.util.List;

import lombok.Data;

@Data
public class Cell extends AbstractEntityAuditable {
	
	private Boolean isRevealed = false;
	private Boolean isFlagged = false;
	private Boolean isMine = false;
	private Integer neighborMines = 0;//amount of mines that are neighbor of this cell
	private List<Cell> neighborCells;
	

}
