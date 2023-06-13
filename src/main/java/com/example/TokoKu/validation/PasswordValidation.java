package com.example.TokoKu.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidation implements ConstraintValidator<Password,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.isEmpty() || value.toLowerCase().contains("password")) {
            return false;
        }

        if (value.length() < 8) {
            return false;
        }

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;

        for (char c : value.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSymbol = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSymbol;
    }
}
