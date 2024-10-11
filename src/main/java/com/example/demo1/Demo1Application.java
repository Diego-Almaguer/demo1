package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.demo1.services.ServiceDefault;

@SpringBootApplication
public class Demo1Application {
	@Autowired
	ServiceDefault serviceDefault;

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void init() {
		// Lógica que deseas ejecutar al iniciar la aplicación
		System.out.println("Mi servicio personalizado ha iniciado");
		serviceDefault.crear();

		// Aquí puedes agregar más código para inicializar recursos o configurar
		// variables
	}
}
