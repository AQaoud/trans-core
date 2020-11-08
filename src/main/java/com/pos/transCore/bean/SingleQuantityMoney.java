package com.pos.transCore.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class SingleQuantityMoney{
    private double amount;
    private String currency;
}
