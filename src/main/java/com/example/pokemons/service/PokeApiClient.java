package com.example.pokemons.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class PokeApiClient {

    public JSONObject getDamageInfo(String typeName) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get("https://pokeapi.co/api/v2/type/" + typeName).
                header("accept", "application/json")
                .asJson();
        return response.getBody().getObject();
    }
}
