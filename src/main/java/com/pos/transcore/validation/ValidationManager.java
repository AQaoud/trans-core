package com.pos.transcore.validation;

import com.pos.transcore.bean.Transaction;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Validation manager for core inputs.
 */
public class ValidationManager {


    /**
     * Validates <code>Transaction</code> object.
     *
     * @param trans - Transaction object
     */
    public static void validate(Transaction trans, Locale locale) {
        if (trans == null) {
            throw new IllegalArgumentException("Transaction object is null");
        }

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Transaction>> constraints = validator.validate(trans);
        if (!CollectionUtils.isEmpty(constraints)) {
            throw new ValidationException(prepareValidationMessage(constraints, locale));
        }
    }

    private static String prepareValidationMessage(Set<ConstraintViolation<Transaction>> constraints, Locale locale) {
        Locale finalLocale = locale != null ? locale : Locale.getDefault();
        ResourceBundle bundle = ResourceBundle.getBundle("messages", finalLocale);

        MessageFormat formatter = new MessageFormat(bundle.getString("exception.validate.transaction"), finalLocale);
        String message = formatter.format(new Object[]{constraints.stream()
                .map(c -> c.getMessage()).collect(Collectors.joining("\n"))});
        return message;
    }


}
