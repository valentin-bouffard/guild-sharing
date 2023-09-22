package com.guildsharing.guildsharing.dtos;

import com.guildsharing.guildsharing.validators.BirthdayAge;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.Date;

@Data
@BirthdayAge
public class PokemonDTO {
    @NotNull
    private String name;
    @NotNull @PositiveOrZero
    private Integer age;
    @NotNull @PastOrPresent private Date birthday;
}
