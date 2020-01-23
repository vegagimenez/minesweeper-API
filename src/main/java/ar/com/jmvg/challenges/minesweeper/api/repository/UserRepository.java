package ar.com.jmvg.challenges.minesweeper.api.repository;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.cloud.gcp.data.datastore.repository.query.Query;
import org.springframework.data.repository.query.Param;

import ar.com.jmvg.challenges.minesweeper.api.model.User;

public interface UserRepository extends DatastoreRepository<User, Long> {
	
	@Query("select * from  |ar.com.jmvg.challenges.minesweeper.api.model.User| where email = @email and password = @pass")
	User findByLoginAndPass(@Param("email") String login, @Param("pass") String pass);

}
