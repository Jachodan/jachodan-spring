package com.jaegokeeper.hwan.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCreateRequestDTO {

    private Integer storeId;
    private String itemName;
    private Integer quantity;
}
