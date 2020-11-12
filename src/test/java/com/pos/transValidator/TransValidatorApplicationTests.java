package com.pos.transValidator;

import com.pos.transcore.bean.*;
import com.pos.transcore.validation.ValidationManager;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class TransValidatorApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test_validation_exception_en_locale() {
        Transaction t = prepareTrans(false);
        ValidationException exc = Assertions.assertThrows(ValidationException.class, () -> ValidationManager.validate(t, null));
        Assertions.assertTrue(exc.getMessage().contains("Invalid"));
    }

    private Transaction prepareTrans(boolean valid) {
        Transaction t = new Transaction();
        t.setId(String.valueOf(RandomUtils.nextInt()));
        Itemization itemization = new Itemization();
        TotalMoney totalMoney = new TotalMoney();
        totalMoney.setAmount(2.00);
        totalMoney.setCurrency("JOD");
        itemization.setTotalMoney(totalMoney);
        NetSalesMoney netSalesMoney = new NetSalesMoney();
        netSalesMoney.setAmount(1.0);
        netSalesMoney.setCurrency("JOD");
        itemization.setNetSalesMoney(netSalesMoney);
        List<Tax> taxes = new ArrayList<>();
        Tax tax =  new Tax();
        AppliedMoney appliedMoney = new AppliedMoney();
        if (valid) {
            appliedMoney.setAmount(1.0);
        } else {
            appliedMoney.setAmount(1.5);
        }

        appliedMoney.setCurrency("JOD");
        tax.setAppliedMoney(appliedMoney);
        taxes.add(tax);
        itemization.setTaxes(taxes);
        List<Itemization> itemizations = new ArrayList<>();
        itemizations.add(itemization);
        t.setItemization(itemizations);
        return t;
    }

    @Test
    public void test_validation_exception_ar_locale() {
        Transaction t = prepareTrans(false);
        ValidationException exc = Assertions.assertThrows(ValidationException.class, () -> ValidationManager.validate(t, new Locale("ar")));
        Assertions.assertTrue(exc.getMessage().contains("عملية غير مقبولة"));



    }

    @Test
    public void test_valid_transaction() {
        Transaction t = prepareTrans(true);
        Assertions.assertDoesNotThrow(() -> ValidationManager.validate(t, new Locale("ar")),"Test failed due to validation exception");
    }


}
