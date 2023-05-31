package com.company.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mouse extends BaseDomain {
    private Integer numberButtons;
    private Boolean forGame;
    private Boolean wireless;
    private Double length;

    @Builder(builderMethodName = "childBuilder")
    public Mouse(Long id, String color, Double price, Integer quantity, Integer numberButtons,
                 Boolean forGame, Boolean wireless, Double length) {
        super(id, color, price, quantity);
        this.numberButtons = numberButtons;
        this.forGame = forGame;
        this.wireless = wireless;
        this.length = length;
    }
}
