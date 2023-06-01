package com.tuan3jpa.tuan3jpa.validator;
import com.tuan3jpa.tuan3jpa.Repository.IuserRepository;
import com.tuan3jpa.tuan3jpa.validator.annotation.ValidUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
//    ************************************
    private IuserRepository userRepository;
    @Override
    public boolean isValid(String username, ConstraintValidatorContext context){
        if(userRepository== null)
        {
            return true;
        }
//        *******************************************
        return  userRepository.findByUsername(username) == null;

    }


}
