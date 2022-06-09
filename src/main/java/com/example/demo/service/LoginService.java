package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.LoginInterface;
import com.example.demo.interfaces.LoginRepository;
import com.example.demo.modelo.Login;

//
/**
 * The Class LoginService.
 *  @author Alejandro
 */
@Service
public class LoginService implements LoginInterface {

	/** The repo. */
	@Autowired
	private LoginRepository repo;

	/**
	 * Login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the login
	 */
	public Login login(String username, String password) {
		Login user = repo.findByNameAndPassword(username, password);
		return user;
	}
	
	
	 /**
 	 * List.
 	 *
 	 * @return the list
 	 */
 	public List<Login> list(){
	        return repo.findAll();
	    }
	/**
	 * Listar.
	 *
	 * @return the list
	 */
	@Override
	public List<Login> listar() {
		return (List<Login>) repo.findAll();
	}

	/**
	 * Listar id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	@Override
	public Optional<Login> listarId(int id) {
		return repo.findById((long) id);
	}

	/**
	 * Save.
	 *
	 * @param p the p
	 * @return the int
	 */
	@Override
	public int save(Login p) {
		int res = 0;
		Login login = repo.save(p);
		if (!login.equals(null)) {
			res = 1;
		}
		System.out.println("mensaje"+login.getName());
		return res;
	}

	/**
	 * Register.
	 *
	 * @param p the p
	 * @return the string
	 */
	@Override
	public String register(Login p) {
		boolean comprobacion = listar().stream().anyMatch(user -> user.getName().equals(p.getName()));
		String mensaje;

		if (comprobacion) {
			mensaje = "existente";
		} else {
			save(p);
			mensaje = "guardado";
		}
		return mensaje;
	}

	/**
	 * Exists by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean existsById(long id){
        return repo.existsById(id);
    }
	
	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	@Override
	public void delete(long id) {
		repo.deleteById((long) id);
	}


	/**
	 * Delete.re
	 *
	 * @param id the id
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


	 /**
 	 * Gets the by username.
 	 *
 	 * @param username the username
 	 * @return the by username
 	 */
 	public Optional<Login> getByUsername(String username){
	        return repo.findByName(username);
	    }


	 /**
 	 * Exists by username.
 	 *
 	 * @param username the username
 	 * @return true, if successful
 	 */
 	public boolean existsByUsername(String username){
	        return repo.existsByName(username);
	    }

	  /**
  	 * Gets the one.
  	 *
  	 * @param id the id
  	 * @return the one
  	 */
  	public Optional<Login> getOne(long id){
	        return repo.findById(id);
	    }




	

}