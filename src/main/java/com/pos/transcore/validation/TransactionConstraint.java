package com.pos.transcore.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Functional interface for constraints to be applied on
 * Transactions
 */
@Documented
@Constraint(validatedBy = TransactionValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionConstraint {

    /**
     * @return constraint violation message.
     */
    String message() default "'total money', 'single quantity money', 'gross sales money', 'discount money' "
            + " values doesn't reflect 'net sales money' value"; // TODO more specific errors

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
