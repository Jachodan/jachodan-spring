package com.jaegokeeper.hwan.service;

import com.jaegokeeper.hwan.dto.ItemDetailDTO;
import com.jaegokeeper.hwan.dto.ItemListDTO;
import com.jaegokeeper.hwan.dto.ItemCreateRequestDTO;
import com.jaegokeeper.hwan.dto.PageResponseDTO;

import java.util.List;

public interface ItemService {

    Integer registerItem(ItemCreateRequestDTO itemCreateRequestDTO);

    PageResponseDTO<ItemListDTO> getItemList(Integer storeId, int page, int size, List<String> filters, String keyword);

    ItemDetailDTO getItemDetail(Integer storeId, Integer itemId);

}
