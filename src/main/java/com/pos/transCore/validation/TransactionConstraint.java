package com.pos.transCore.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TransactionValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionConstraint {

        String message() default "total_money,single_quantity_money,gross_sales_money,discount_money " +
                "fields values are not reflected successfully by net_sales_money field"; // TODO locale + more specific errors
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
}
