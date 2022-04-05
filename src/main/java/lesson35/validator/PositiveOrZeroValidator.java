package lesson35.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PositiveOrZeroValidator implements ConstraintValidator<PositiveOrZero, Integer> {


    private PositiveOrZero annotation;

    @Override
    public void initialize(PositiveOrZero constraintAnnotation) {
        this.annotation = constraintAnnotation;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value < 0) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("Возникла ошибка проверки значения")
                    .addPropertyNode(annotation.property())
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
