package com.pos.transcore.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class TotalCollectedMoney {
    private double amount;
    private String currency;
}
