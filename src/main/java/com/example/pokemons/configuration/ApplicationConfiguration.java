package com.example.pokemons.configuration;

import com.example.pokemons.service.PokeApiClient;
import org.springframework.context.annotation.Bean;

public class ApplicationConfiguration {

    @Bean
    public PokeApiClient pokeApiClientClient() {
        return new PokeApiClient();
    }
}
