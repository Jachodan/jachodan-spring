package com.jaegokeeper.hwan.service;

import com.jaegokeeper.hwan.domain.Item;
import com.jaegokeeper.hwan.domain.Stock;
import com.jaegokeeper.hwan.dto.ItemCreateRequestDTO;
import com.jaegokeeper.hwan.mapper.ItemMapper;
import com.jaegokeeper.hwan.mapper.StockMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;
    private final StockMapper stockMapper;

    @Transactional
    @Override
    public Integer registerItem(ItemCreateRequestDTO itemCreateRequestDTO) {

        Item item = new Item();
        item.setStoreId(itemCreateRequestDTO.getStoreId());
        item.setItemName(itemCreateRequestDTO.getItemName());

        itemMapper.insertItem(item);


        Stock stock = new Stock();
        stock.setItemId(item.getItemId());
        stock.setStoreId(itemCreateRequestDTO.getStoreId());
        stock.setQuantity(itemCreateRequestDTO.getQuantity());

        stockMapper.insertStock(stock);

        return item.getItemId();
    }
}
