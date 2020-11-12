package com.pos.transcore.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class Tender {
    private String type;
    private String name;
    private TotalMoney totalMoney;
}
