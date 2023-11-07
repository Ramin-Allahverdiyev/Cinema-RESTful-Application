package com.CinemaApp.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SeatLimitValidator.class)
public @interface SeatLimit {
    String message() default "The number of seats for the hall can not be grater than 30!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
