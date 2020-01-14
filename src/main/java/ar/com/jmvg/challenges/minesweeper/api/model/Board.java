package ar.com.jmvg.challenges.minesweeper.api.model;

import java.util.Arrays;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Board extends AbstractEntityAuditable {

	private static final long serialVersionUID = -3961132912525314845L;

	private final Game game;
	private final Integer mines;
	private final Cell[][] cells;
	
	public Board(Game game) {
		this.game = game;
		this.mines = game.getConfig().getDifficulty().getMines();
		this.cells = new Cell[game.getConfig().getDifficulty().getRows()][game.getConfig().getDifficulty().getColumns()];
		Arrays.setAll(this.cells, c-> new Cell());
	}
}
