package ar.com.jmvg.challenges.minesweeper.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.jmvg.challenges.minesweeper.api.model.User;
import ar.com.jmvg.challenges.minesweeper.api.repository.UserRepository;

/**
 * User service implementation, yes I can create Interfaces for the every service but I think for some projects
 * it's better to start coding features and let the abstraction when you need to have it, before that, you could lose precious time
 * discussing the better abstraction or anything else...anyway... is arguable.
 * 
 * Like Thanos said: "Perfectly balanced." (velocity/feature)
 * */
@Service
public class UserService {
	
	private final static String FAKE_TOKEN = "ewoJImFsZyI6ICJSUzI1NiIKfSAKewoJInN1YiI6ICJ3aGF0ZXZlcml3YW50IiwKCSJncmFudC1hY2Nlc3MiOiBbewoJCSJhcHBsaWNhdGlvbiI6ICJhcHBuYW1lIiwKCQkiYWNjZXNzIjogW10KCX1dLAoJImlzcyI6ICJodHRwczpcL1wvaXNzdWVyLm1lIiwKCSJyZWZyZXNoRXhwaXJhdGlvbiI6IDE1Nzk3MzQxMzEsCgkiZXhwIjogMTU3OTcyNzgzMSwKCSJpYXQiOiAxNTc5NzI2OTMxCn0=";
	
	@Autowired
	UserRepository repo;
	
	public User login(String login, String pass) {
	
		User user = repo.findByLoginAndPass(login, pass);
		if(null == user) {
			user = new User();
			user.setEmail(login);
			user.setPassword(pass);
			user = saveOrUpdate(user);
		}
		user.setToken(FAKE_TOKEN);
		return user;
	}

	public User getUserbyId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User saveOrUpdate(User user) {
		return repo.save(user);
	}

}
