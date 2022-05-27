package com.example.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Imagen.
 *  @author Alejandro
 */
@Entity
@Table(name = "imagenes")
public class Imagen {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	/** The titulo. */
	@Column(name = "titulo")
	private String titulo;

	/** The descripcion. */
	@Column(name = "descripcion")
	private String descripcion;

	/** The image URL. */
	@Column(name = "imageURL")
	private String imageURL;
	
	/**
	 * Gets the image URL.
	 *
	 * @return the image URL
	 */
	public String getimageURL() {
		return imageURL;
	}

	/**
	 * Sets the image URL.
	 *
	 * @param imageURL the new image URL
	 */
	public void setimageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/** The publicado. */
	@Column(name = "publicado")
	private boolean publicado;

	

	
	/**
	 * Instantiates a new imagen.
	 */
	public Imagen() {

	}
	

	/**
	 * Instantiates a new imagen.
	 *
	 * @param titulo the titulo
	 * @param descripcion the descripcion
	 * @param imageURL the image URL
	 * @param publicado the publicado
	 */
	public Imagen(String titulo, String descripcion, String imageURL, boolean publicado) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imageURL = imageURL;
		this.publicado = publicado;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Gets the titulo.
	 *
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Sets the titulo.
	 *
	 * @param titulo the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Gets the descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Sets the descripcion.
	 *
	 * @param descripcion the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Es publicado.
	 *
	 * @return true, if successful
	 */
	public boolean esPublicado() {
		return publicado;
	}

	/**
	 * Sets the publicado.
	 *
	 * @param esPublicado the new publicado
	 */
	public void setPublicado(boolean esPublicado) {
		this.publicado = esPublicado;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", titulo=" + titulo + ", desc=" + descripcion + ", publicado=" + publicado + "]";
	}

}