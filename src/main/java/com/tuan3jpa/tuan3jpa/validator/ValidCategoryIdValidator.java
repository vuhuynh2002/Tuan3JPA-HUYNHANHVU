package com.tuan3jpa.tuan3jpa.validator;
import com.tuan3jpa.tuan3jpa.validator.annotation.ValidCategoryId;
import com.tuan3jpa.tuan3jpa.entity.Category;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.metamodel.mapping.EntityMappingType;
import jakarta.validation.ConstraintValidator;



public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context) {
         return category!=null && category.getId() !=null;
    }

}
