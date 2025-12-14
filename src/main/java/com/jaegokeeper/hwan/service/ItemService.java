package com.jaegokeeper.hwan.service;

import com.jaegokeeper.hwan.dto.ItemListDTO;
import com.jaegokeeper.hwan.dto.ItemCreateRequestDTO;

import java.util.List;

public interface ItemService {

    Integer registerItem(ItemCreateRequestDTO itemCreateRequestDTO);

    List<ItemListDTO> getItemList(Integer storeId);
}
