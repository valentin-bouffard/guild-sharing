package com.guildsharing.guildsharing.services;

import com.guildsharing.guildsharing.dtos.PokemonDTO;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    public void processPokemon(PokemonDTO pokemonDTO) {
        System.out.println("""
            <%s> {type %s} {%d in months}
        """.formatted(
                pokemonDTO.getName().toUpperCase(),
                pokemonDTO.getBirthday().toString(),
                pokemonDTO.getAge() / 12 ));
    }
}
