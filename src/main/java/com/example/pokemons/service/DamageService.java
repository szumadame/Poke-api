package com.example.pokemons.service;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DamageService {

    public PokeApiClient pokeApiClient = new PokeApiClient();

    public ArrayList<String> getNoDamageToTypes(String typeName) throws UnirestException {
        JSONObject jsonObject = pokeApiClient.getDamageInfo(typeName);
        JSONArray noDamageToSpecificType = jsonObject.getJSONObject("damage_relations").getJSONArray("no_damage_to");
        ArrayList<String> noDamageToTheseTypes = new ArrayList<>();
        for (int i = 0; i <= noDamageToSpecificType.length() - 1; i++) {
            noDamageToTheseTypes.add((String) noDamageToSpecificType.getJSONObject(i).get("name"));
        }
        return noDamageToTheseTypes;
    }

    public ArrayList<String> getHalfDamageToTypes(String typeName) throws UnirestException {
        JSONObject jsonObject = pokeApiClient.getDamageInfo(typeName);
        JSONArray halfDamageToSpecificType = jsonObject.getJSONObject("damage_relations").getJSONArray("half_damage_to");
        ArrayList<String> halfDamageToTheseTypes = new ArrayList<>();
        for (int i = 0; i <= halfDamageToSpecificType.length() - 1; i++) {
            halfDamageToTheseTypes.add((String) halfDamageToSpecificType.getJSONObject(i).get("name"));
        }
        return halfDamageToTheseTypes;
    }

    public ArrayList<String> getDoubleDamageToTypes(String typeName) throws UnirestException {
        JSONObject jsonObject = pokeApiClient.getDamageInfo(typeName);
        JSONArray doubleDamageToSpecificType = jsonObject.getJSONObject("damage_relations").getJSONArray("double_damage_to");
        ArrayList<String> doubleDamageToTheseTypes = new ArrayList<>();
        for (int i = 0; i <= doubleDamageToSpecificType.length() - 1; i++) {
            doubleDamageToTheseTypes.add((String) doubleDamageToSpecificType.getJSONObject(i).get("name"));
        }
        return doubleDamageToTheseTypes;
    }

    public double getDamageRatio(String attackingType, String attackedType) throws UnirestException {
        double damageRatio = 1;
        ArrayList<String> noDamage = getNoDamageToTypes(attackingType);
        if (noDamage.contains(attackedType)) {
            return damageRatio * 0;
        }
        ArrayList<String> halfDamage = getHalfDamageToTypes(attackingType);
        if (halfDamage.contains(attackedType)) {
            return damageRatio * 0.5;
        }
        ArrayList<String> doubleDamage = getDoubleDamageToTypes(attackingType);
        if (doubleDamage.contains(attackedType)) {
            return damageRatio * 2;
        }
        return damageRatio;
    }
}
