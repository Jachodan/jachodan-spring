package com.jaegokeeper.hwan.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ItemModifyRequestDTO {

    @NotBlank(message = "itemName은 필수입니다.")
    private String itemName;

//    @NotNull(message = "quantity는 필수입니다.")
//    private Integer quantity;

    @NotNull
    private Boolean favoriteYn;

    private Integer imageId;

    @NotNull
    private Integer safeQuantity;

    @NotNull
    private Integer targetQuantity;
}

