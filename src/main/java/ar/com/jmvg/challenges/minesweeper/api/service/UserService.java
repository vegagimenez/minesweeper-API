package ar.com.jmvg.challenges.minesweeper.api.service;

import org.springframework.stereotype.Service;

import ar.com.jmvg.challenges.minesweeper.api.model.User;

/**
 * User service implementation, yes I can create Interfaces for the every service but I think for some projects
 * it's better to start coding features and let the abstraction when you need to have it, before that, you could lose precious time
 * discussing the better abstraction or anything else...anyway... is arguable.
 * 
 * Like Thanos said: "Perfectly balanced." (velocity/feature)
 * */
@Service
public class UserService {

	public User login(String login, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserbyId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
