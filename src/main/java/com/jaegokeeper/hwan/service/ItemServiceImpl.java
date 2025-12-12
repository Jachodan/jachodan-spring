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

        Integer quantity = itemCreateRequestDTO.getQuantity();
        String itemName = itemCreateRequestDTO.getItemName();
        Integer storeId = itemCreateRequestDTO.getStoreId();
        if (storeId <= 0) {
            throw new IllegalArgumentException("storeId는 1 이상이어야 합니다.");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("quantity는 0 이상이어야 합니다.");
        }

        Item item = new Item();
        item.setStoreId(storeId);
        item.setItemName(itemName);

        itemMapper.insertItem(item);


        Stock stock = new Stock();
        stock.setItemId(item.getItemId());
        stock.setStoreId(storeId);
        stock.setQuantity(quantity);

        stockMapper.insertStock(stock);

        return item.getItemId();
    }
}
