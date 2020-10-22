package com.juegos.backend.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.juegos.backend.enums.Tecnologia;

@Entity
public class VideoJuego {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	@Column(name = "año")
	private String anio;
	private String protagonista;
	private String director;
	private String productor;
	
	@Enumerated(EnumType.STRING)
	private Tecnologia tecnologia;
	private String marca;
	private double precioJuego;
	private int stock;
	
	public VideoJuego() {
		
	}

	public VideoJuego(String nombre, String anio, String protagonista, String director, String productor,
			Tecnologia tecnologia, String marca, double precioJuego, int stock) {
		this.nombre = nombre;
		this.anio = anio;
		this.protagonista = protagonista;
		this.director = director;
		this.productor = productor;
		this.tecnologia = tecnologia;
		this.marca = marca;
		this.precioJuego = precioJuego;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getProtagonista() {
		return protagonista;
	}

	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public Tecnologia getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Tecnologia tecnologia) {
		this.tecnologia = tecnologia;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecioAlquiler() {
		return precioJuego;
	}

	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioJuego = precioAlquiler;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
