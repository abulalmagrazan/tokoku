package com.example.TokoKu.validation;

import com.example.TokoKu.dao.ShopRepository;
import com.example.TokoKu.service.interfacefile.ShopService;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ShopNameValidation implements ConstraintValidator<ShopName,Object> {

    @Autowired
    ShopRepository repository;


    private String shopNameField;

    private String shopIdField;

    @Override
    public void initialize(ShopName constraintAnnotation) {

        this.shopNameField= constraintAnnotation.usernameField();
        this.shopIdField= constraintAnnotation.idShopField();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String nameValue= new BeanWrapperImpl(o).getPropertyValue(shopNameField).toString();
        Long idValue=(Long) new BeanWrapperImpl(o).getPropertyValue(shopIdField);

        var hasil= repository.shopNameCount(nameValue,idValue);
        if(hasil>0){
            return false;
        }
        return true;
    }

}
