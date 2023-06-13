package com.example.TokoKu.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ShopNameValidation.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ShopName {

    public Class<?>[] groups() default{};
    public Class<? extends Payload>[] payload() default{};
    public String message() default "Shop Name Already Exist";

    public String usernameField();
    public String idShopField();

}
