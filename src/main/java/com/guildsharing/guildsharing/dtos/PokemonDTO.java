package com.guildsharing.guildsharing.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class PokemonDTO {
    @NotNull
    private String name;
    @NotNull private Integer age;
    @NotNull private Date birthday;
}
