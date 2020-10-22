package com.juegos.backend.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Alquiler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date fechaAlquiler;
	@Temporal(TemporalType.DATE)
	private Date fechaEntrega;
	private double precioAlquiler;
	
	private int id_cliente;
	private int id_juego;

	public Alquiler() {

	}

	
	public Alquiler( Date fechaAlquiler, Date fechaEntrega, double precioAlquiler, int id_cliente,
			int id_juego) {
		this.fechaAlquiler = fechaAlquiler;
		this.fechaEntrega = fechaEntrega;
		this.precioAlquiler = precioAlquiler;
		this.id_cliente = id_cliente;
		this.id_juego = id_juego;
	}

	

	public int getId() {
		return id;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}


	public int getId_juego() {
		return id_juego;
	}


	public void setId_juego(int id_juego) {
		this.id_juego = id_juego;
	}


	public void setId(int id) {
		this.id = id;
	}

	public double getPrecioAlquiler() {
		return precioAlquiler;
	}

	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
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

}
