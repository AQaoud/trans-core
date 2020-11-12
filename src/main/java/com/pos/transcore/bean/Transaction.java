package com.pos.transcore.bean;

import com.pos.transcore.validation.TransactionConstraint;
import lombok.Data;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
@Setter
@Valid
@TransactionConstraint
public class Transaction {

    @Valid
    @NotEmpty
    private String id;
    private String businessId;
    private String locationId;
    private String transactionId;
    private String receiptId;
    private String serialNumber;
    private String diningOption;
    private Date creationTime;
    private DiscountMoney discountMoney;
    private AdditiveTaxMoney additiveTaxMoney;
    private InclusiveTaxMoney inclusiveTaxMoney;
    private RefundedMoney refundedMoney;
    private TaxMoney taxMoney;
    private TipMoney tipMoney;
    private TotalCollectedMoney totalCollectedMoney;
    private Creator creator;
    private Tender tender;
    private List<Tax> taxes;
    private List<Itemization> itemization;
}
