package ar.com.jmvg.challenges.minesweeper.api.service;

import org.springframework.stereotype.Service;

import ar.com.jmvg.challenges.minesweeper.api.exception.MinesweeperAPIException;
import ar.com.jmvg.challenges.minesweeper.api.exception.MinesweeperAPIExceptionHelper;
import ar.com.jmvg.challenges.minesweeper.api.model.Board;
import ar.com.jmvg.challenges.minesweeper.api.model.Cell;
import ar.com.jmvg.challenges.minesweeper.api.model.Position;

@Service
public class CellService {

	private static final String ERR_MSG_TMPL = "Can't init Cells in null field: ";
	private static final Position[] adjacentCoordinates = {new Position(-1,-1),new Position(-1,0),new Position(-1,1),new Position(0,-1),
			new Position(0,1), new Position(1,-1),new Position(1,0),new Position(1,1)};
	
	/**
	 * This method initialize the adjacent cells for every cell in the board, so when a click to reveal is received
	 * The cell resolves their state and passes the command to every existent neighbor
	 * */
	public void initNeighborhoodCells(Board board) throws MinesweeperAPIException {
		
		if(null == board)
			throw MinesweeperAPIExceptionHelper.invalidArgumentsException(Board.class.getName(), ERR_MSG_TMPL);

		int rows = board.getDifficulty().getRows();
		int columns = board.getDifficulty().getColumns();
		
		for (int row = 0; row < rows; row++) {
            
			for (int column = 0; column < columns; column++) {
                //Cell cell = board.getCells()[row][column];
                Position position = new Position(row,column);
                
                for (Position adjPos : adjacentCoordinates) {
					//if(adjPos.isAdjacent(position))
						//cell.getNeighborCells().add(board.getCells()[adjPos.getX()][adjPos.getY()]);
				}
            }
		}
		
	}
	
	public void initMines(Board board) throws MinesweeperAPIException {
		//TODO: Implement code to init Mines
	}

}
