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
}
