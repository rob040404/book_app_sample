package com.bookworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 *  para habilitar la funcionalidad de auditoría automática en JPA. Esto permite que campos como createdDate, lastModifiedDate, 
 *  o campos relacionados con el usuario que crea o modifica entidades se actualicen automáticamente sin necesidad de hacerlo manualmente.
 */
@SpringBootApplication

public class BookWorldUsersAuthMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookWorldUsersAuthMicroApplication.class, args);
	}

}

