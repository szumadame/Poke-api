package com.example.pokemons;

import com.example.pokemons.configuration.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ApplicationConfiguration.class)
public class PokemonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonsApplication.class, args);
	}
}
