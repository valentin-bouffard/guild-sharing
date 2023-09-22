package com.guildsharing.guildsharing.dtos;

import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
public class PokemonDTO {
    private String name;
    private Integer age;
    private Date birthday;

}
