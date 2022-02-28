package br.com.meli.pokedexreactive.repository;

import br.com.meli.pokedexreactive.model.Pokemon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends ReactiveMongoRepository<Pokemon, String> {
}
