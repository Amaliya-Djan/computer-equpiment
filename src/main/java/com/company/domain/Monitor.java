package com.company.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Monitor extends BaseDomain {
    private Integer refreshRate;
    private Integer displaySize;
    private Boolean speaker;
    private String company;

    @Builder(builderMethodName = "childBuilder")
    public Monitor(Long id, String color, Double price, Integer quantity, Integer refreshRate,
                   Integer displaySize, Boolean speaker, String company) {
        super(id, color, price, quantity);
        this.refreshRate = refreshRate;
        this.displaySize = displaySize;
        this.speaker = speaker;
        this.company = company;
    }
}
