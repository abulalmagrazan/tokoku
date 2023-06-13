package com.example.TokoKu.validation;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidation implements ConstraintValidator<ConfirmPassword,Object> {

    private String passwordField;
    private String retypeField;

    @Override
    public void initialize(ConfirmPassword constraintAnnotation) {
        this.passwordField= constraintAnnotation.passwordField();
        this.retypeField= constraintAnnotation.retypeField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String passwordValue= new BeanWrapperImpl(o).getPropertyValue(passwordField).toString();
        String retypeValue= new BeanWrapperImpl(o).getPropertyValue(retypeField).toString();
        if(passwordValue.equals(retypeValue)){return true;}
        return false;
    }
}
