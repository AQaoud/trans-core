package com.pos.transCore.validation;

import com.pos.transCore.bean.Tax;
import com.pos.transCore.bean.Transaction;
import com.pos.transCore.utils.Utilities;
import com.pos.transCore.bean.Itemization;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionValidator implements
        ConstraintValidator<TransactionConstraint, Transaction> {

    @Override
    public void initialize(TransactionConstraint constraint) {
    }

    @Override
    public boolean isValid(Transaction trans,
                           ConstraintValidatorContext cxt) {
        return trans.getItemization().stream().allMatch(itemization -> {
            return isValid(itemization);
        });
    }

    private boolean isValid(Itemization itemization) {
        return Utilities.equal(itemization.getTotal_money().getAmount()
                , itemization.getNet_sales_money().getAmount()
                        + getItemTaxesTotal(itemization.getTaxes()), 0.0001); // TODO move to constructor
    }

    private double getItemTaxesTotal(List<Tax> taxes) {
        return taxes.stream().collect(Collectors.summingDouble(value -> value.getApplied_money().getAmount()));
    }

}
