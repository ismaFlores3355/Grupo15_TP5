package ar.edu.unju.fi.ejercicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages ={ "ar.edu.unju.fi.controller","ar.edu.unju.fi.model","ar.edu.unju.fi.util"})
public class Tp5Grupo15Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp5Grupo15Application.class, args);
	}

}
