package com.pos.transCore.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class Tax{
    private String id;
    private String name;
    private double rate;
    private String inclusion_type;
    private Boolean is_custom_amount;
    private AppliedMoney applied_money;
}
