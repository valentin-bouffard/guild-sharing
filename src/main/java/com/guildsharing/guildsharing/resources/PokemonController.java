package com.guildsharing.guildsharing.resources;

import com.guildsharing.guildsharing.dtos.PokemonDTO;
import com.guildsharing.guildsharing.services.PokemonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PokemonController {

    private final PokemonService pokemonService;

    @PostMapping("api/pokemon")
    public ResponseEntity<Void> getPokemon(@RequestBody PokemonDTO pokemonDTO) {
        pokemonService.processPokemon(pokemonDTO);
        return ResponseEntity.ok().build();
    }
}
