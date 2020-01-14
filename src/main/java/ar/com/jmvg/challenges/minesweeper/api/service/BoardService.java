package ar.com.jmvg.challenges.minesweeper.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.jmvg.challenges.minesweeper.api.exception.MinesweeperAPIException;
import ar.com.jmvg.challenges.minesweeper.api.model.Board;
import ar.com.jmvg.challenges.minesweeper.api.model.Game;

@Service
public class BoardService {

	@Autowired
	private CellService cellService;
	
	public Board initBoard(Game game) throws MinesweeperAPIException {
		
		Board board = new Board(game);
		cellService.initNeighborhoodCells(board);
		
		return board;
	}

}
