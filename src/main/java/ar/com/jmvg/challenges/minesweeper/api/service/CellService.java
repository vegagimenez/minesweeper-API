package ar.com.jmvg.challenges.minesweeper.api.service;

import ar.com.jmvg.challenges.minesweeper.api.exception.MinesweeperAPIException;
import ar.com.jmvg.challenges.minesweeper.api.exception.MinesweeperAPIExceptionHelper;
import ar.com.jmvg.challenges.minesweeper.api.model.Board;
import ar.com.jmvg.challenges.minesweeper.api.model.Cell;

public class CellService {

	private static final String ERR_MSG_TMPL = "Can't init Cells in null field: ";
	
	/**
	 * This method initialize the adjacent cells for every cell in the board, so when a click to reveal is received
	 * The cell resolves their state and passes the command to every existent neighbor
	 * */
	public void initNeighborhoodCells(Board board) throws MinesweeperAPIException {
		
		if(null == board)
			throw MinesweeperAPIExceptionHelper.invalidArgumentsException(Board.class.getName(), ERR_MSG_TMPL);

		int rows = board.getGame().getConfig().getDifficulty().getRows();
		int columns = board.getGame().getConfig().getDifficulty().getColumns();
		
		for (int row = 0; row < rows; row++) {
            
			for (int column = 0; column < columns; column++) {
                Cell Cell = board.getCells()[row][column];
                //TODO: Here I'll init eveery cell and neighbor

            }
		}
		
	}

}
