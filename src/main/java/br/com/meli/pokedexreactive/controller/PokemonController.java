package br.com.meli.pokedexreactive.controller;

import br.com.meli.pokedexreactive.model.Pokemon;
import br.com.meli.pokedexreactive.repository.PokemonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private PokemonRepository pokemonRepository;

    public PokemonController(PokemonRepository pokemonRepository){
        this.pokemonRepository = pokemonRepository;
    }

    @GetMapping("/get/all")
    public ResponseEntity<Flux<Pokemon>> getAllPokemons(){
        return ResponseEntity.ok().body(pokemonRepository.findAll());
    }

    @GetMapping("/get/{id}")
    public Mono<ResponseEntity<Pokemon>> getPokemonById(@PathVariable String id){
        return pokemonRepository.findById(id)
                .map(pokemon -> ResponseEntity.ok(pokemon))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping("/post")
    public Mono<ResponseEntity<Pokemon>> postPokemon(@RequestBody Pokemon pokemon){
        return pokemonRepository.save(pokemon).thenReturn(ResponseEntity.status(HttpStatus.CREATED).build());
    }

    @GetMapping("/ping")
    public String pong(){
        return "pong";
    }
}
