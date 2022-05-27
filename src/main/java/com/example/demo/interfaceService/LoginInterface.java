package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Login;

// TODO: Auto-generated Javadoc
/**
 * The Interface IpersonajeService.
 */
public interface LoginInterface {
	
	/**
	 * Listar.
	 *
	 * @return the list
	 */
	public List<Login> listar();

	/**
	 * Listar id.
	 *
	 * @param id the id
	 * @return the optional
	 */
	public Optional<Login> listarId(int id);

	/**
	 * Save.
	 *
	 * @param p the p
	 * @return the int
	 */
	public int save(Login p);

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	public void delete(int id);

	/**
	 * Login.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the login
	 */
	public Login login(String username, String password);

	/**
	 * Register.
	 *
	 * @param p the p
	 * @return the string
	 */
	public String register(Login p);

	/**
	 * Delete.
	 *
	 * @param id the id
	 */
	void delete(long id);
}
