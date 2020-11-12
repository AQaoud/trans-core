package com.pos.transcore.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class Variation {
    private String id;
    private String name;
    private String pricingType;
    private PriceMoney priceMoney;
}
