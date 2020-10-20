package com.juegos.backend.dto;

public class ClienteDto {
	
	private String documento;
	private String tipoDocumento;
	private String nombreCompleto;
	private String telefono;
	private String correo;
	
	public ClienteDto() {
		
	}

	public ClienteDto(String documento, String tipoDocumento, String nombreCompleto, String telefono, String correo) {
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.correo = correo;
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
