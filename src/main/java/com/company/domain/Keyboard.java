package com.company.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Keyboard extends BaseDomain {
    private Boolean lamps;
    private Double width;
    private Double height;

    @Builder(builderMethodName = "childBuilder")
    public Keyboard(Long id, String color, Double price, Integer quantity, Boolean lamps, Double width, Double height) {
        super(id, color, price, quantity);
        this.lamps = lamps;
        this.width = width;
        this.height = height;
    }
}
