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
    @NotNull(message = "Name can't be null")
    private String name;
    @NotNull(message = "Age can't be null") @PositiveOrZero(message = "Age must be positive or zero")
    private Integer age;
    @NotNull(message = "Birthday can't be null") @PastOrPresent(message = "Birthday can't be in the future") private Date birthday;
}
