package com.pos.transCore.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class Variation{
    private String id;
    private String name;
    private String pricing_type;
    private PriceMoney price_money;
}
