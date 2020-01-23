package ar.com.jmvg.challenges.minesweeper.api.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Cell extends AbstractEntityAuditable {
	
	private static final long serialVersionUID = 8894745749330323416L;

	private Boolean isRevealed = false;
	private Boolean isFlagged = false;
	private Boolean isMine = false;
	private Integer neighborMines = 0;//amount of mines that are neighbor of this cell
	private List<Cell> neighborCells = new ArrayList<Cell>();

}
