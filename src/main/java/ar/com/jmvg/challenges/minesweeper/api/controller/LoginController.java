package ar.com.jmvg.challenges.minesweeper.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.jmvg.challenges.minesweeper.api.exception.MinesweeperAPIException;
import ar.com.jmvg.challenges.minesweeper.api.model.User;
import ar.com.jmvg.challenges.minesweeper.api.service.UserService;

/**
 * Class to publish login feature to api.
 * 
 * */
@RestController
@RequestMapping("/api/login")
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value = {"/",""}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> doLogin(@RequestParam String login, @RequestParam String pass) throws MinesweeperAPIException {
		logger.info("INIT: login user.");
		User user = userService.login(login, pass);
		logger.info("END: login user.");
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
