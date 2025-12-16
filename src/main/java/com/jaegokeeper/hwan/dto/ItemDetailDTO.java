package com.jaegokeeper.hwan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor

public class ItemDetailDTO {

    private Integer itemId;
    private String itemName;
    private Integer quantity;
    private Boolean favoriteYn;
    private String imageUrl;
    private Integer safeQuantity;
    private LocalDateTime lastUpdatedAt;
}
