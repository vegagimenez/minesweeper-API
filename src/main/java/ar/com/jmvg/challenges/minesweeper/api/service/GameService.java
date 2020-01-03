package ar.com.jmvg.challenges.minesweeper.api.service;

import ar.com.jmvg.challenges.minesweeper.api.exception.MinesweeperAPIException;
import ar.com.jmvg.challenges.minesweeper.api.exception.MinesweeperAPIExceptionHelper;
import ar.com.jmvg.challenges.minesweeper.api.model.Difficulty;
import ar.com.jmvg.challenges.minesweeper.api.model.Game;
import ar.com.jmvg.challenges.minesweeper.api.model.GameConfig;
import ar.com.jmvg.challenges.minesweeper.api.model.User;

public class GameService {

	private static final String ERR_MSG_TMPL = "%s of the game can't be null";
	
	public Game getGameById(Long id) throws MinesweeperAPIException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * saving a new Game instance and starts the game.
	 * */
	public Game saveNewGame(Game game) throws MinesweeperAPIException {
		
		if(null == game ) {
			throw MinesweeperAPIExceptionHelper.invalidArgumentsException(String.format(ERR_MSG_TMPL, Game.class.getName()));
		} else if (null == game.getConfig()) {
			throw MinesweeperAPIExceptionHelper.invalidArgumentsException(String.format(ERR_MSG_TMPL, GameConfig.class.getName()));
		} else if (null == game.getUser()) {
			throw MinesweeperAPIExceptionHelper.invalidArgumentsException(String.format(ERR_MSG_TMPL, User.class.getName()));
		}
		
		Difficulty difficulty = game.getConfig().getDifficulty();
		switch (difficulty) {
		case DOPE:
			
			break;
		case NO_DOPE:
			break;
		case I_EAT_MINES:
			break;
		default:
			break;
		}
		
		return null;
	}

}
