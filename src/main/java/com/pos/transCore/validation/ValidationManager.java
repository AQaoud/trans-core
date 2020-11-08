package com.pos.transCore.validation;

import com.pos.transCore.bean.Transaction;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ValidationManager {


    public static Set<ConstraintViolation<Transaction>> validate(Transaction trans) {
        if (trans == null) {
            throw new IllegalArgumentException("Transaction object is null");
        }

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        return validator.validate(trans);
    }


}
