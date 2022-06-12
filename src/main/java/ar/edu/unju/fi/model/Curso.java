package ar.edu.unju.fi.model;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



public class Curso {
	
	//@Min(value=1,message="El codigo debe ser mayor o igual a 1")
	private int codigo;
	
	@NotBlank(message="El titulo no puede ser blanco")
	private String titulo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaFin;
	
	@Min(value=1, message="las horas deben ser mayores a 1")
	private int horas;
	
	@NotBlank(message="La modalidad no puede ser blanco")
	private String modalidad;
	
	
	private Docente docente;
	
	
	@NotEmpty(message="la categoria no puede ser vacio")
	private String categoria;
	//profe
	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(int codigo, String titulo, LocalDate fechaInicio, LocalDate fechaFin, int horas, String modalidad,
			Docente docente, String categoria) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horas = horas;
		this.modalidad = modalidad;
		this.docente = docente;
		this.categoria = categoria;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
}
