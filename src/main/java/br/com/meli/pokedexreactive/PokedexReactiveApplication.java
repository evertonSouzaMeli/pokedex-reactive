package br.com.meli.pokedexreactive;

import br.com.meli.pokedexreactive.model.Pokemon;
import br.com.meli.pokedexreactive.repository.PokemonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import reactor.core.publisher.Flux;

@SpringBootApplication
@ImportAutoConfiguration(exclude = EmbeddedMongoAutoConfiguration.class)
public class PokedexReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(PokedexReactiveApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ReactiveMongoOperations operations, PokemonRepository repository) {
        return args -> {
            Flux<Pokemon> pokemonFlux = Flux.just(
                    new Pokemon(null, "Bulbasauro", "Semente", "Overgrow", 6.09),
                    new Pokemon(null, "Charizard", "Fogo", "Blaze", 90.05),
                    new Pokemon(null, "Caterpie", "Minhoca", "Poeira do Escudo", 2.09),
                    new Pokemon(null, "Blastoise", "Marisco", "Torrent", 6.09))
                    .flatMap(repository::save);

            pokemonFlux.thenMany(repository.findAll()).log().subscribe(System.out::println);
        };
    }
}
