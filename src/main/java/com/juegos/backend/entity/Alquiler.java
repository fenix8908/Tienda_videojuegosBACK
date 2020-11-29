package com.juegos.backend.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Alquiler implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date fechaAlquiler;
	private Date fechaEntrega;
	private double precioAlquiler;
	@JoinColumn(name = "fk_cliente")
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JsonIgnoreProperties("alquileres")
	private Cliente cliente;
	@JoinColumn(name = "fk_juego")
	@ManyToOne(fetch = FetchType.EAGER,optional = false)
	@JsonIgnoreProperties("alquileres")
	private VideoJuego videoJuego;

	public Alquiler() {

	}

	public Alquiler(int id, Date fechaAlquiler, Date fechaEntrega, double precioAlquiler, Cliente cliente) {
		super();
		this.id = id;
		this.fechaAlquiler = fechaAlquiler;
		this.fechaEntrega = fechaEntrega;
		this.precioAlquiler = precioAlquiler;
		this.cliente = cliente;
	}

	public Alquiler(Date fechaEntrega, double precioAlquiler, Cliente cliente, VideoJuego videoJuego) {
		super();
		this.fechaEntrega = fechaEntrega;
		this.precioAlquiler = precioAlquiler;
		this.cliente = cliente;
		this.videoJuego = videoJuego;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public double getPrecioAlquiler() {
		return precioAlquiler;
	}

	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public VideoJuego getVideoJuego() {
		return videoJuego;
	}

	public void setVideoJuego(VideoJuego videoJuego) {
		this.videoJuego = videoJuego;
	}

	
}
