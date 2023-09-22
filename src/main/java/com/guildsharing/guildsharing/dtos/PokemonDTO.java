package com.guildsharing.guildsharing.dtos;

import com.guildsharing.guildsharing.validators.BirthdayAge;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
@BirthdayAge
public class PokemonDTO {
    @NotNull
    private String name;
    @NotNull private Integer age;
    @NotNull private Date birthday;
}
