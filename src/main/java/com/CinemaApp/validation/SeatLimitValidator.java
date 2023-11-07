package com.CinemaApp.validation;

import com.CinemaApp.entity.Hall;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SeatLimitValidator implements ConstraintValidator<SeatLimit, Hall> {
    @Override
    public void initialize(SeatLimit constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Hall hall, ConstraintValidatorContext context) {
        if (hall == null || hall.getSeats() == null) {
            return true;
        }

        int seatLimit = 30;

        return hall.getSeats().size() <= seatLimit;
    }
}
