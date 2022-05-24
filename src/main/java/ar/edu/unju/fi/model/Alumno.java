package ar.edu.unju.fi.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Alumno {
	@Min(value=1_000_000,message="El DNI debe ser mayor o igual a 1.000.000")
	private int dni;
	
	@Size(min=3,max=100,message="El nombre debe tener entre 3 a 100 caracteres")
	@NotEmpty(message="El nombre del alumno no puede estar vacio")
	private String nombre;
	
	@Size(min=3,max=50,message="El apellido debe tener entre 3 a 50 caracteres")
	@NotEmpty(message="El apellido del alumno no puede estar vacio")
	@NotBlank(message="El apellido del alumno no puede ser blanco")
	private String apellido;
	
	@NotEmpty(message="El correo no puede estar vacio")
	@Email(message="El correo debe contener @")
	private String email;
	
	@NotEmpty(message="El telefono no puede estar vacio")
	private String telefono;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public Alumno(int dni, String nombre, String apellido, String email, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
	
}
