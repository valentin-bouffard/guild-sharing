package com.guildsharing.guildsharing.resources;

import com.guildsharing.guildsharing.dtos.PokemonDTO;
import com.guildsharing.guildsharing.services.PokemonService;
import com.guildsharing.guildsharing.validators.Name;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@Validated
public class PokemonController {

    private final PokemonService pokemonService;

    @PostMapping("api/pokemons")
    public ResponseEntity<Void> getPokemon(@Valid @RequestBody PokemonDTO pokemonDTO) {
        pokemonService.processPokemon(pokemonDTO);
        return ResponseEntity.ok().build();
    }


    @PostMapping("api/pokemons/{name}")
    @Name
    public ResponseEntity<Void> getPokemon(@Valid @RequestBody PokemonDTO pokemonDTO, @PathVariable("name") String name) {
        pokemonService.processPokemon(pokemonDTO);
        return ResponseEntity.ok().build();
    }
}
