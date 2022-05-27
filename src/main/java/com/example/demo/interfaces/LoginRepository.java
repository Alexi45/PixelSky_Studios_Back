package com.example.demo.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Login;

// TODO: Auto-generated Javadoc
/**
 * The Interface LoginRepository.
 *  @author Alejandro
 */
@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
	
	/**
	 * Find by username and password.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the login
	 */
	Login findByNameAndPassword(String username, String password);

	/**
	 * Exists by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	boolean existsById(int id);

	/**
	 * Exists by username.
	 *
	 * @param nombre the nombre
	 * @return true, if successful
	 */
	boolean existsByName(String nombre);

	 /**
 	 * Find by username.
 	 *
 	 * @param username the username
 	 * @return the optional
 	 */
 	Optional<Login> findByName(String username);
}