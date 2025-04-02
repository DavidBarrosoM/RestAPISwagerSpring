package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.demo.service.*;
import com.example.demo.model.*;

@SpringBootApplication
//@ComponentScan(basedPackages="com.example.demo")
public class RestApiSwagerSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiSwagerSpringApplication.class, args);
	}
	@Bean
	CommandLineRunner init(Servicio service) {
		return args ->{
			service.agregarProyecto(new Proyect(1L,"Patatito","Java",true));
			
		};
	}
}
