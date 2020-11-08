package com.pos.transCore.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Valid
@Data
@Setter
@NoArgsConstructor
public class Itemization{
    private String id;
    private String name;
    private int quantity;
    private TotalMoney total_money;
    private SingleQuantityMoney single_quantity_money;
    private GrossSalesMoney gross_sales_money;
    private DiscountMoney discount_money;
    @NotNull
    private NetSalesMoney net_sales_money;
    private Category category;
    private Variation variation;
    private List<Tax> taxes;
    private List<Object> discounts;
    private List<Modifier> modifiers;
}
