package com.example.demo.interfaces;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Imagen;

// TODO: Auto-generated Javadoc
/**
 * The Interface Repository.
 *  @author Alejandro
 */
public interface Repository extends CrudRepository<Imagen, Long> {
	 
 	/**
 	 * Find by publicado.
 	 *
 	 * @param publicado the publicado
 	 * @return the list
 	 */
 	List<Imagen> findByPublicado(boolean publicado);
	 
 	/**
 	 * Find by titulo containing.
 	 *
 	 * @param titulo the titulo
 	 * @return the list
 	 */
 	List<Imagen> findByTituloContaining(String titulo);
}