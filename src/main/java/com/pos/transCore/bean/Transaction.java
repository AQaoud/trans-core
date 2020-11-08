package com.pos.transCore.bean;

import com.pos.transCore.validation.TransactionConstraint;
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
public class Transaction{

    @Valid
    @NotEmpty
    private String _id; //TODO update fields names with _
    private String business_id; // TODO update instance variables to private
    private String location_id;
    private String transaction_id;
    private String receipt_id;
    private String serial_number;
    private String dining_option;
    private Date creation_time;
    private DiscountMoney discount_money;
    private AdditiveTaxMoney additive_tax_money;
    private InclusiveTaxMoney inclusive_tax_money;
    private RefundedMoney refunded_money;
    private TaxMoney tax_money;
    private TipMoney tip_money;
    private TotalCollectedMoney total_collected_money;
    private Creator creator;
    private Tender tender;
    private List<Tax> taxes;
    private List<Itemization> itemization;
}
