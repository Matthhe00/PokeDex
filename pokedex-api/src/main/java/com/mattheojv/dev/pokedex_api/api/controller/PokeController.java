package com.mattheojv.dev.pokedex_api.api.controller;

import org.springframework.web.bind.annotation.*;

import com.mattheojv.dev.pokedex_api.service.FindPokeService;

@RestController
@RequestMapping("/api/dex")
@CrossOrigin(origins = "*")
public class PokeController {

    private final FindPokeService pokeService;

    public PokeController(FindPokeService pokeService) {
        this.pokeService = pokeService;
    }

    @GetMapping("/poke")
    public Object getPoke(@RequestParam String idOrName) {
        return pokeService.fetchPokemon(idOrName);
    }

    @GetMapping("/poke-details")
    public Object getMethodName(@RequestParam String idOrName) {
        return pokeService.fetchPokemonDetails(idOrName);
    }
    
    @GetMapping("/gen")
    public Object getGen(@RequestParam String id) {
        return pokeService.fetchPokemonGeneration(id);
    }
    
}