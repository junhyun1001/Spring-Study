package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import umc.spring.domain.enums.Gender;
import umc.spring.validation.annotation.ExistGender;

import java.util.EnumSet;

@Component
public class GenderExistValidator implements ConstraintValidator<ExistGender, String> {

    @Override
    public void initialize(ExistGender constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return EnumSet.allOf(Gender.class).stream().anyMatch(g -> g.name().equals(value));
    }
}
