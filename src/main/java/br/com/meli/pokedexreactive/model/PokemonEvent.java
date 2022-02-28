package br.com.meli.pokedexreactive.model;

import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PokemonEvent {
    private Long eventId;
    private String eventType;
}
