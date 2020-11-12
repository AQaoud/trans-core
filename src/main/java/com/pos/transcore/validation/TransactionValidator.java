package com.pos.transcore.validation;

import com.pos.transcore.bean.Itemization;
import com.pos.transcore.bean.Tax;
import com.pos.transcore.bean.Transaction;
import com.pos.transcore.utils.Utilities;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Validation class for transactions.
 */
public class TransactionValidator implements
        ConstraintValidator<TransactionConstraint, Transaction> {

    public static final double DOUBLE_IGNORED_DIFF = 0.0001;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(final TransactionConstraint constraint) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(final Transaction trans,
                           final ConstraintValidatorContext cxt) {
        return trans.getItemization().stream().allMatch(itemization -> {
            return isValid(itemization);
        });
    }

    private boolean isValid(Itemization itemization) {
        return Utilities.equal(itemization.getTotalMoney().getAmount()
                , itemization.getNetSalesMoney().getAmount()
                        + getItemTaxesTotal(itemization.getTaxes()), DOUBLE_IGNORED_DIFF);
    }

    private double getItemTaxesTotal(List<Tax> taxes) {
        return taxes.stream().collect(Collectors.summingDouble(
                value -> value.getAppliedMoney().getAmount()));
    }

}
