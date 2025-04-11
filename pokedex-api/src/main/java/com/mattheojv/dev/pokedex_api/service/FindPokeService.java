package com.mattheojv.dev.pokedex_api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FindPokeService {

    private final RestTemplate restTemplate;

    public FindPokeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public Map<String, Object> fetchPokemon(String idOrName) {
        String url = "https://tyradex.app/api/v1/pokemon/" + idOrName;
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
    
        Map<String, Object> names = (Map<String, Object>) response.get("name");
        String frenchName = (String) names.get("fr");
    
        Integer pokedexNumber = (Integer) response.get("pokedex_id");

        Map<String, Object> sprites = (Map<String, Object>) response.get("sprites");
        String defaultSprite = (String) sprites.get("regular");
    
        return Map.of(
            "name", frenchName,
            "pokedex_number", pokedexNumber,
            "sprite", defaultSprite
        );
    }

    public Object fetchPokemonDetails(String idOrName) {
        String url = "https://tyradex.app/api/v1/pokemon/" + idOrName + "/details";
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        return response;
    }

    public Object fetchPokemonGeneration(String gen) {
        if (gen == null || gen.isEmpty()) {
            return "Veuillez fournir un numéro de génération valide.";
        }

        String url = "https://tyradex.app/api/v1/gen/" + gen;

        List<?> response = restTemplate.getForObject(url, List.class); 
        List<Map<String, Object>> responseMap = new ArrayList<>();
    
        if (response != null) {
            for (Object pokemon : response) {
                if (pokemon instanceof Map) {
                    Map<String, Object> pokemonMap = (Map<String, Object>) pokemon;
                    Map<String, Object> names = (Map<String, Object>) pokemonMap.get("name");
                    String frenchName = (String) names.get("fr");
    
                    Integer pokedexNumber = (Integer) pokemonMap.get("pokedex_id");
    
                    Map<String, Object> sprites = (Map<String, Object>) pokemonMap.get("sprites");
                    String defaultSprite = (String) sprites.get("regular");
    
                    responseMap.add(
                        Map.of(
                            "name", frenchName,
                            "pokedex_number", pokedexNumber,
                            "sprite", defaultSprite
                        )
                    );
                }
            }
            return responseMap;
        }
        return responseMap;
    }

}