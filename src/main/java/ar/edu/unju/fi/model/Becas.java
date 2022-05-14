package ar.edu.unju.fi.model;

import java.time.LocalDate;


public class Becas {
	private int codigo;
	private Curso curso;
	private LocalDate fechaApertura;
	private LocalDate fechaCierre;
	private String estado;
	
	public Becas() {
	}
	
	public Becas(int codigo, Curso curso, LocalDate fechaApertura, LocalDate fechaCierre) {
		super();
		this.codigo = codigo;
		this.curso = curso;
		this.fechaApertura = fechaApertura;
		this.fechaCierre = fechaCierre;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public LocalDate getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(LocalDate fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public LocalDate getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDate fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	
}
