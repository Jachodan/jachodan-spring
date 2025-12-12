package com.jaegokeeper.hwan.service;

import com.jaegokeeper.hwan.dto.ItemCreateRequestDTO;

public interface ItemService {

    Integer registerItem(ItemCreateRequestDTO itemCreateRequestDTO);
}
