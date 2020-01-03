package ar.com.jmvg.challenges.minesweeper.api.controller;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiAuthToken;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.annotation.ApiVersion;
import org.jsondoc.core.pojo.ApiStage;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.com.jmvg.challenges.minesweeper.api.exception.MinesweeperAPIException;
import ar.com.jmvg.challenges.minesweeper.api.model.Game;
import ar.com.jmvg.challenges.minesweeper.api.service.GameService;
import lombok.extern.slf4j.Slf4j;

/**
 * Class responsible to manage every action for the Game
 * @author mvega
 * 
 **/
@Api(name = "Minesweeper API", description = "Methods for managing games", group = "Game", visibility = ApiVisibility.PUBLIC, stage = ApiStage.BETA)
@ApiVersion(since = "1.0")
@ApiAuthToken
@Slf4j
@RestController
@RequestMapping("/minesweeper/api/game")
public class GameController {

	@Autowired
	private GameService gameService;
	
	@ApiMethod
	@RequestMapping(method = RequestMethod.GET, value = {"/{id}"}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Game> getGame(@RequestHeader(required = true, value = HttpHeaders.AUTHORIZATION) String authorizationHeader,
			@PathVariable("id") Long id) throws MinesweeperAPIException {
		log.info("INIT: getting Game by id:" + id);
		Game game = gameService.getGameById(id);
		log.info("END: retrieving Game by id:" + id);
		
		return new ResponseEntity<Game>(game, HttpStatus.OK);
		
	}
	
	@ApiMethod
	@ApiResponseObject
	@RequestMapping(method = RequestMethod.POST, value = {"/",""}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Game> startNewGame(@RequestHeader(required = true, value = HttpHeaders.AUTHORIZATION) String authorizationHeader,
			@RequestBody Game game) throws MinesweeperAPIException {
		log.info("INIT: creating a new Game for user:" + game.getUser().getEmail());
		Game newGame = gameService.saveNewGame(game);
		log.info("END: retrieving new Game with id:" + game.getId());
		
		return new ResponseEntity<Game>(newGame, HttpStatus.OK);
	}
}
