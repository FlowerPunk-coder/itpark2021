package lesson35.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PositiveOrZeroValidator.class)
public @interface PositiveOrZero {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String property() default "";

}

