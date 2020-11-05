package com.juegos.backend.dto;

import java.util.Date;

public class AlquilerDTO {


	private Date fechaAlquiler;
	private Date fechaEntrega;
	private double precioAlquiler;
	private int fk_cliente;
	private int fk_juego;
	
	
	public AlquilerDTO(Date fechaAlquiler, Date fechaEntrega, double precioAlquiler, int fk_cliente, int fk_juego) {
		super();
		this.fechaAlquiler = fechaAlquiler;
		this.fechaEntrega = fechaEntrega;
		this.precioAlquiler = precioAlquiler;
		this.fk_cliente = fk_cliente;
		this.fk_juego = fk_juego;
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


	public int getFk_cliente() {
		return fk_cliente;
	}


	public void setFk_cliente(int fk_cliente) {
		this.fk_cliente = fk_cliente;
	}


	public int getFk_juego() {
		return fk_juego;
	}


	public void setFk_juego(int fk_juego) {
		this.fk_juego = fk_juego;
	}


	


}
