package ar.com.jmvg.challenges.minesweeper.api.controller;

import java.util.ArrayList;
import java.util.List;

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
import ar.com.jmvg.challenges.minesweeper.api.model.User;
import ar.com.jmvg.challenges.minesweeper.api.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/minesweeper/api/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * TODO: Implement pagination feature and parameters validation.
	 * */
	@RequestMapping(method = RequestMethod.GET, value = {"/",""}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<User>> getUserList(@RequestHeader(required = true, value = HttpHeaders.AUTHORIZATION) String authorizationHeader) throws MinesweeperAPIException {
		log.info("INIT: getting user list.");
		List<User> users = new ArrayList<User>();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	/**
	 * This would require a double check on the token so a USER only can get their information
	 * or if we use the same uri to implement a CRUD we should check if the user in the token have permissions to 
	 * get the user info.
	 * With SpringBoot we could use ROLES to do that.
	 * */
	@RequestMapping(method = RequestMethod.GET, value = {"/{id}"}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> getUser(@RequestHeader(required = true, value = HttpHeaders.AUTHORIZATION) String authorizationHeader,
			@PathVariable("id") Long id) throws MinesweeperAPIException {
		log.info("INIT: getting user by id:" + id);
		User user = userService.getUserbyId(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = {"/",""}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> createUser(@RequestHeader(required = true, value = HttpHeaders.AUTHORIZATION) String authorizationHeader,
			@RequestBody User user) throws MinesweeperAPIException {
		log.info("INIT: saving a new user.");
		User userSaved = userService.saveOrUpdate(user);
		return new ResponseEntity<User>(userSaved, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = {"/",""}, produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<User> updateUser(@RequestHeader(required = true, value = HttpHeaders.AUTHORIZATION) String authorizationHeader,
			@RequestBody User user) throws MinesweeperAPIException {
		log.info("INIT: updating user.");
		User userUpdated = userService.saveOrUpdate(user);
		return new ResponseEntity<User>(userUpdated, HttpStatus.OK);
	}
}
