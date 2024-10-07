package com.makainb.springboot3.security.s008.repository;

import com.makainb.springboot3.security.s008.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
			attributePaths = {"authorities"})
	Optional<User> findByUsername(String username);
	
	@EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
			attributePaths = {"authorities"})
	List<User> findAll();
}