package ar.com.jmvg.challenges.minesweeper.api.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ar.com.jmvg.challenges.minesweeper.api.exception.MinesweeperAPIException;
import ar.com.jmvg.challenges.minesweeper.api.exception.MinesweeperAPIExceptionHelper;
import ar.com.jmvg.challenges.minesweeper.api.model.Board;
import ar.com.jmvg.challenges.minesweeper.api.model.Cell;
import ar.com.jmvg.challenges.minesweeper.api.model.Position;

@Service
public class CellService {

	private static final String ERR_MSG_TMPL = "Can't init Cells in null field: ";
	
	/**
	 * This method initialize the adjacent cells for every cell in the board, so when a click to reveal is received
	 * The cell resolves their state and passes the command to every existent neighbor
	 * */
	public void initNeighborhoodCells(Board board) throws MinesweeperAPIException {
		
		if(null == board)
			throw MinesweeperAPIExceptionHelper.invalidArgumentsException(Board.class.getName(), ERR_MSG_TMPL);

		int rows = board.getDifficulty().getRows();
		int columns = board.getDifficulty().getColumns();
		//iterate rows
		for (int row = 0; row < rows; row++) {
			// iterate columns
			for (int column = 0; column < columns; column++) {
                //get each cell in the row
				Cell cell = board.getCells()[row][column];
				//load the cell position in the matrix
                Position cellPosition = new Position(row,column);
                cell.setPosition(cellPosition);
                //Check their adjacent cell positions
                Cell[] idxRows = board.getCells()[row];
                
//                		Arrays.stream(board.getCells()[row])
//                			.filter(c -> Math.abs(c.getPosition().getX()-row) < 2)
//                			.collect(Collectors.toList());
//                
//                 = arr.each_index.select { |i| (i-r).abs < 2 }
//                cols_ndx = arr.first.size.times.select { |j| (j-c).abs < 2 }
//                rows_ndx.each_with_object([]) do |i,a| 
//                  cols_ndx.each { |j| a << arr[i][j] unless [i,j] == [r,c] }
//                end
            }
		}
		
	}
	
	public void initMines(Board board) throws MinesweeperAPIException {
		//TODO: Implement code to init Mines
	}

}
