package com.example.TokoKu.validation;

import com.example.TokoKu.dao.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckAccountUsernameValidation implements ConstraintValidator<CheckAccountUsername,String> {

    @Autowired
    private AccountRepository repository;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        var hasil=repository.getCountUsername(value);
        if(hasil>0){
            return false;
        }
        return true;
    }
}
