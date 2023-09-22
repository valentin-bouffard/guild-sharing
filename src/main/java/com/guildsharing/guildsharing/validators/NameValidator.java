package com.guildsharing.guildsharing.validators;

import com.guildsharing.guildsharing.dtos.PokemonDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

import java.time.Year;
import java.util.Calendar;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class NameValidator  implements ConstraintValidator<Name, Object[]> {

    @Override
    public boolean isValid(Object[] object, ConstraintValidatorContext constraintContext) {
        if (object == null) {
            return true;
        }

        if (object.length != 2) {
            constraintContext
                    .buildConstraintViolationWithTemplate("number of arguments is invalid")
                    .addConstraintViolation();
            return false;
        }

        if (!(object[0] instanceof PokemonDTO pokemonDTO)) {
            constraintContext
                    .buildConstraintViolationWithTemplate("first argument must be a PokemonDTO")
                    .addConstraintViolation();
            return false;
        }

        if (!(object[1] instanceof String name)) {
            constraintContext
                    .buildConstraintViolationWithTemplate("second argument must be a String")
                    .addConstraintViolation();
            return false;
        }
        return name.equals(pokemonDTO.getName());
    }
}
