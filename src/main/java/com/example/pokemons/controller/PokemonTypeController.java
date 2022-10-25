package com.example.pokemons.controller;

import com.example.pokemons.service.DamageService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonTypeController {

    @Autowired
    DamageService damageService;

    @GetMapping("/types/{attackingType}/{attackedType}")
    ResponseEntity<Double> getDamageRatio(@PathVariable String attackingType, @PathVariable String attackedType) throws UnirestException {
        return ResponseEntity.ok(damageService.getDamageRatio(attackingType, attackedType));
    }

    @GetMapping("/types/{attackingType}/{attackedType1}/{attackedType2}")
    ResponseEntity<Double> getDamageRatio(@PathVariable String attackingType, @PathVariable String attackedType1, @PathVariable String attackedType2) throws UnirestException {
        double firstRatio = damageService.getDamageRatio(attackingType, attackedType1);
        double secondRatio = damageService.getDamageRatio(attackingType, attackedType2);
        double combinedRatio = firstRatio * secondRatio;
        return ResponseEntity.ok(combinedRatio);
    }
}
