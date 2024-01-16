package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.GenderExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GenderExistValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistGender {

    String message() default "존재하지 않는 성별입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
