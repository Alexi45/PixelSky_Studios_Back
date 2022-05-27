package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Imagen;
import com.example.demo.interfaces.Repository;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 *  @author Alejandro
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)//TODO
@RestController
@RequestMapping("/api") //TODO
public class Controller {
	
	  /** The tutorial repository. */
  	@Autowired
	  Repository tutorialRepository;

	  /**
  	 * Gets the todos tutoriales.
  	 *
  	 * @param titulo the titulo
  	 * @return the todos tutoriales
  	 */
  	@GetMapping("/tutoriales")
	  public ResponseEntity<List<Imagen>> getTodosTutoriales(@RequestParam(required = false) String titulo) {
		  try {
		      List<Imagen> tutoriales = new ArrayList<Imagen>();

		      if (titulo == null)
		        tutorialRepository.findAll().forEach(tutoriales::add);
		      else
		        tutorialRepository.findByTituloContaining(titulo).forEach(tutoriales::add);

		      if (tutoriales.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(tutoriales, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }

	  /**
  	 * Gets the tutorial por id.
  	 *
  	 * @param id the id
  	 * @return the tutorial por id
  	 */
  	@GetMapping("/tutoriales/{id}")
	  public ResponseEntity<Imagen> getTutorialPorId(@PathVariable("id") long id) {
		  Optional<Imagen> tutorialData = tutorialRepository.findById(id);

		    if (tutorialData.isPresent()) {
		      return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	  }

	  /**
  	 * Crear tutorial.
  	 *
  	 * @param tutorial the tutorial
  	 * @return the response entity
  	 */
  	@PostMapping("/tutoriales")
	  public ResponseEntity<Imagen> crearTutorial(@RequestBody Imagen tutorial) {
		  try {
		      Imagen _tutorial = tutorialRepository.save(new Imagen(tutorial.getTitulo(), tutorial.getDescripcion(),tutorial.getimageURL() ,false));
		      return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }

	  /**
  	 * Actualizar tutorial.
  	 *
  	 * @param id the id
  	 * @param tutorial the tutorial
  	 * @return the response entity
  	 */
  	@PutMapping("/tutoriales/{id}")
	  public ResponseEntity<Imagen> actualizarTutorial(@PathVariable("id") long id, @RequestBody Imagen tutorial) {
		  Optional<Imagen> tutorialData = tutorialRepository.findById(id);

		    if (tutorialData.isPresent()) {
		      Imagen _tutorial = tutorialData.get();
		      _tutorial.setTitulo(tutorial.getTitulo());
		      _tutorial.setDescripcion(tutorial.getDescripcion());
		      _tutorial.setimageURL(tutorial.getimageURL());
		      _tutorial.setPublicado(tutorial.esPublicado());
		      return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	  }

	  /**
  	 * Eliminar tutorial.
  	 *
  	 * @param id the id
  	 * @return the response entity
  	 */
  	@DeleteMapping("/tutoriales/{id}")
	  public ResponseEntity<HttpStatus> eliminarTutorial(@PathVariable("id") long id) {
		  try {
		      tutorialRepository.deleteById(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }

	  /**
  	 * Eliminar todos tutoriales.
  	 *
  	 * @return the response entity
  	 */
  	@DeleteMapping("/tutoriales")
	  public ResponseEntity<HttpStatus> eliminarTodosTutoriales() {
		  try {
		      tutorialRepository.deleteAll();
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }

	  /**
  	 * Find by publicado.
  	 *
  	 * @return the response entity
  	 */
  	@GetMapping("/tutoriales/publicado")
	  public ResponseEntity<List<Imagen>> findByPublicado() {
		  try {
		      List<Imagen> tutoriales = tutorialRepository.findByPublicado(true);

		      if (tutoriales.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(tutoriales, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  
	  }

}