package com.bm.test.bm_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
a ver, definamos el scope, creo que con que puedas tener
registro de usuarios
login
pagina solo para usuarios logueados (si no esta log, te manda al login)
creo que esto te daria el conocimiento general, crear controladores, modelos, rutas, sql y authentication
 */

@SpringBootApplication
public class BmTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmTestApplication.class, args);
	}

}
