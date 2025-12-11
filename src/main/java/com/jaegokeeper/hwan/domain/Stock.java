package com.jaegokeeper.hwan.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stock {

    private Integer StockId;

    private Integer ItemId;

    private Integer StoreId;

    private Integer quantity;

    private Boolean favoriteYn;
}
