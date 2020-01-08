package ar.com.jmvg.challenges.minesweeper.api.service;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.jmvg.challenges.minesweeper.api.exception.MinesweeperAPIException;
import ar.com.jmvg.challenges.minesweeper.api.exception.MinesweeperAPIExceptionHelper;
import ar.com.jmvg.challenges.minesweeper.api.model.Board;
import ar.com.jmvg.challenges.minesweeper.api.model.Game;
import ar.com.jmvg.challenges.minesweeper.api.model.GameConfig;
import ar.com.jmvg.challenges.minesweeper.api.model.User;

public class GameService {

	private static final String ERR_MSG_TMPL = "Game field can't be null: ";
	
	@Autowired
	private BoardService boardService;
	
	public Game getGameById(Long id) throws MinesweeperAPIException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * saving a new Game instance and starts the game.
	 * */
	public Game saveNewGame(Game game) throws MinesweeperAPIException {
		
		if(null == game ) {
			throw MinesweeperAPIExceptionHelper.invalidArgumentsException(Game.class.getName(), ERR_MSG_TMPL);
		} else if (null == game.getConfig()) {
			throw MinesweeperAPIExceptionHelper.invalidArgumentsException(GameConfig.class.getName(), ERR_MSG_TMPL);
		} else if (null == game.getUser()) {
			throw MinesweeperAPIExceptionHelper.invalidArgumentsException(User.class.getName(), ERR_MSG_TMPL);
		}
		
		Board board = boardService.initBoard(game);
		game.setBoard(board);
		
		
		return game;
	}

}
