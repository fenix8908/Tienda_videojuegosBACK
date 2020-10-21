package com.juegos.backend.criterios;

import com.juegos.backend.enums.Tecnologia;

import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.StringFilter;

public class CriterioBusqueda {//criterios de busqueda para  clase VideoJuego
	
	public static class TecnoFilter extends Filter<Tecnologia>{}
	private StringFilter director;
	private StringFilter protagonista;
	private StringFilter productor;
	private StringFilter marca;
	private TecnoFilter tecno;
	
	//getter y setters
	public StringFilter getDirector() {
		return director;
	}
	public void setDirector(StringFilter director) {
		this.director = director;
	}
	public StringFilter getProtagonista() {
		return protagonista;
	}
	public void setProtagonista(StringFilter protagonista) {
		this.protagonista = protagonista;
	}
	public StringFilter getProductor() {
		return productor;
	}
	public void setProductor(StringFilter productor) {
		this.productor = productor;
	}
	public StringFilter getMarca() {
		return marca;
	}
	public void setMarca(StringFilter marca) {
		this.marca = marca;
	}
	public TecnoFilter getTecno() {
		return tecno;
	}
	public void setTecno(TecnoFilter tecno) {
		this.tecno = tecno;
	}
	
	
}
