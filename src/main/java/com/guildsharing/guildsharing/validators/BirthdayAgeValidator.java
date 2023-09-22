package com.guildsharing.guildsharing.validators;

import com.guildsharing.guildsharing.dtos.PokemonDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;
import java.util.Calendar;

public class BirthdayAgeValidator implements ConstraintValidator<BirthdayAge, PokemonDTO> {
    @Override
    public boolean isValid(PokemonDTO pokemonDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (null == pokemonDTO) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(pokemonDTO.getBirthday());
        return calendar.get(Calendar.YEAR) == calculateBirthday(pokemonDTO);
    }

    private static int calculateBirthday(PokemonDTO pokemonDTO) {
        return Year.now().getValue() - pokemonDTO.getAge();
    }
}
