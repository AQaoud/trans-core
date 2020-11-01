package com.pos.transValidator.com.pos.transValidator.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class Modifier{
    private String id;
    private String name;
    private int quantity;
    private AppliedMoney applied_money;
}
