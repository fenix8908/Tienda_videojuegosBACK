package com.juegos.backend.dto;

import java.util.Date;

public class AlquilerDTO {


	private Date fechaAlquiler;
	private Date fechaEntrega;
	private double precioAlquiler;
	private int id_cliente;
	private int id_juego;
	
	
	public AlquilerDTO(Date fechaAlquiler, Date fechaEntrega, double precioAlquiler, int id_cliente, int id_juego) {
		super();
		this.fechaAlquiler = fechaAlquiler;
		this.fechaEntrega = fechaEntrega;
		this.precioAlquiler = precioAlquiler;
		this.id_cliente = id_cliente;
		this.id_juego = id_juego;
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
	


}
