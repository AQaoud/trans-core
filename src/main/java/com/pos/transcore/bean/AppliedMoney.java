package com.pos.transcore.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class AppliedMoney {
    private double amount;
    private String currency;
}
