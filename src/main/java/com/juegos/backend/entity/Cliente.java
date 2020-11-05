package com.juegos.backend.entity;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String documento;
	private String tipoDocumento;
	private String nombreCompleto;
	private String telefono;
	private String correo;
	@OneToMany(mappedBy = "cliente")
	private List<Alquiler> alquileres;

	public Cliente(){

	}

	public Cliente(String documento, String tipoDocumento, String nombreCompleto, String telefono, String correo,
			List<Alquiler> alquileres) {
		super();
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.correo = correo;
		this.alquileres = alquileres;
	}

	public Cliente(String documento, String tipoDocumento, String nombreCompleto, String telefono, String correo) {
		super();
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.correo = correo;
	}
	public Cliente(int id,String documento, String tipoDocumento, String nombreCompleto, String telefono, String correo) {
		super();
		this.id = id;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.correo = correo;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
}
