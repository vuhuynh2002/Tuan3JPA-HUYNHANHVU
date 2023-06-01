package com.tuan3jpa.tuan3jpa.validator;

import com.tuan3jpa.tuan3jpa.entity.User;
import com.tuan3jpa.tuan3jpa.validator.annotation.ValidUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator  implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if(user == null)
            return true;
        return user.getId() !=null;
    }
}
