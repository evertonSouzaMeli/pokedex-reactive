package br.com.meli.pokedexreactive.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pokemon")
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Pokemon {
    @Id
    private String id;
    private String nome;
    private String categoria;
    private String habilidade;
    private Double peso;
}
