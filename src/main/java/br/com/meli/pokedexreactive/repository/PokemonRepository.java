package br.com.meli.pokedexreactive.repository;

import br.com.meli.pokedexreactive.model.Pokemon;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PokemonRepository extends ReactiveMongoRepository<Pokemon, String> {

    default Mono<Pokemon> update(String id, Pokemon pokemon){
        Mono<Pokemon> result = findById(id);
        return result.map(pkmn -> {
            pkmn.setNome(pokemon.getNome());
            pkmn.setCategoria(pokemon.getCategoria());
            pkmn.setHabilidade(pokemon.getHabilidade());
            pkmn.setPeso(pokemon.getPeso());
            return pkmn;
        });
    }
}
