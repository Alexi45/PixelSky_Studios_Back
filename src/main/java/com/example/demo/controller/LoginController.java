package com.example.demo.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.interfaces.LoginRepository;
import com.example.demo.modelo.Login;

import com.example.demo.service.LoginService;

import antlr.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginController.
 *  @author Alejandro
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LoginController {

	/** The loginrepo. */
	@Autowired
	private LoginRepository loginrepo;

	/** The user service. */
	@Autowired
	private LoginService userService;

	/**
	 * Editar.
	 *
	 * @param id the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Login> login = userService.listarId(id);
		model.addAttribute("login", login);
		return "form";
	}

	/**
	 * Eliminar.
	 *
	 * @param model the model
	 * @param id the id
	 * @return the string
	 */
	@GetMapping("/delete/{id}")
	public String eliminar(Model model, @PathVariable int id) {
		userService.delete(id);
		return "redirect:/listar";
	}

	/**
	 * Agregar.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("login", new Login());
		return "formulario";
	}

	/**
	 * Save.
	 *
	 * @param p the p
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/save")
	public String save(@Valid @RequestBody Login p, Model model) {

		System.out.println(p.getName()+p.getPassword());
		p.setScore("0");
		p.setUrl("https://www.kindpng.com/picc/m/24-248253_user-profile-default-image-png-clipart-png-download.png");
		return userService.register(p);

	}

	/**
	 * Listar.
	 *
	 * @param model the model
	 * @return the string
	 */
	
	@GetMapping("/listar")
	public List<Login> listar(Model model) {
		List<Login> logins = userService.listar();
		model.addAttribute("logins", logins);
		loginrepo.findAll().forEach(logins::add);
		
		return userService.listar();
	}
	
	/**
	 * List.
	 *
	 * @return the response entity
	 */
	
	@GetMapping("/lista")
    public ResponseEntity<List<Login>> list(){
        List<Login> list = userService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
	
	/**
	 * Logear.
	 *
	 * @param model the model
	 * @param username the username
	 * @param password the password
	 * @return the string
	 */
	@GetMapping("/login/{username}/{password}")
	public String logear(Model model, @PathVariable String username, @PathVariable String password) {

		Login oauthUser = userService.login(username, password);

		System.out.print(username);
		System.out.print(oauthUser);
		if (Objects.nonNull(oauthUser)) {

			return "funciono";

		} else {
			return "f";

		}
	}

	/**
	 * Delete.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")long id){
        if(!userService.existsById(id))
            return new ResponseEntity(("no existe"), HttpStatus.NOT_FOUND);
        userService.delete(id);
        return new ResponseEntity(("producto eliminado"), HttpStatus.OK);
    }
	

	
	/**
	 * Update employee.
	 *
	 * @param id the id
	 * @param logino the logino
	 * @return the response entity
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<Login> updateUser(@PathVariable Long id, @RequestBody Login logino){
	
		Login login = loginrepo.findById(id)
				.orElseThrow();
		
		login.setName(logino.getName());
		login.setPassword(logino.getPassword());
		login.setPhone(logino.getPhone());
		login.setUrl(logino.getUrl());
		login.setEmail(logino.getEmail());
		
		
		Login updatedEmployee = loginrepo.save(login);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 */
	@GetMapping("/detail/{id}")
    public ResponseEntity<Login> getById(@PathVariable("id") long id){
        if(!userService.existsById(id))
            return new ResponseEntity( HttpStatus.NOT_FOUND);
        Login login = userService.getOne(id).get();
        return new ResponseEntity(login, HttpStatus.OK);
    }
	

	
	
	/**
	 * Gets the login by name.
	 *
	 * @param name the name
	 * @return the login by name
	 */
	@GetMapping("/users/{name}")
	public ResponseEntity<Login> getLoginByName(@PathVariable String name) {
		Login login = loginrepo.findByName(name)
				.orElseThrow();
		return ResponseEntity.ok(login);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}