package ar.edu.unju.fi.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Component
public class Becas {
	@Min(value=1,message="El codigo debe ser mayor o igual a 1")
	private int codigo;
	
	private Curso curso;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaApertura;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaCierre;
	//@NotBlank(message="El estado no puede ser blanco")
	private String estado;
	
	public Becas() {
		this.curso=new Curso();
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
