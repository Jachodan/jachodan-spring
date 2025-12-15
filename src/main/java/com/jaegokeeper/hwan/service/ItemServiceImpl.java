package com.jaegokeeper.hwan.service;

import com.jaegokeeper.hwan.domain.Item;
import com.jaegokeeper.hwan.domain.Stock;
import com.jaegokeeper.hwan.dto.ItemListDTO;
import com.jaegokeeper.hwan.dto.ItemCreateRequestDTO;
import com.jaegokeeper.hwan.dto.PageResponseDTO;
import com.jaegokeeper.hwan.mapper.ItemMapper;
import com.jaegokeeper.hwan.mapper.StockMapper;
import com.jaegokeeper.hwan.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;
    private final StockMapper stockMapper;
    private final StoreMapper storeMapper;

    @Transactional
    @Override
    public Integer registerItem(ItemCreateRequestDTO itemCreateRequestDTO) {

        String itemName = itemCreateRequestDTO.getItemName();
        Integer storeId = itemCreateRequestDTO.getStoreId();
        if (storeId <= 0) {
            throw new IllegalArgumentException("storeId는 1 이상이어야 합니다.");
        }

        int count = storeMapper.countById(storeId);
        if (count == 0) {
            throw new IllegalArgumentException("존재하지 않는 매장입니다.");
        }

        Integer quantity = itemCreateRequestDTO.getQuantity();
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

    @Transactional
    @Override
    public PageResponseDTO<ItemListDTO> getItemList(Integer storeId, int page, int size, List<String> filters, String keyword) {

        if (storeId == null || storeId <= 0) {
            throw new IllegalArgumentException("storeId는 필수이며 1 이상이어야 합니다.");
        }
        if (page <= 0) {
            throw new IllegalArgumentException("page는 1 이상이어야 합니다.");
        }
        if (size <= 0 || size > 50) {
            throw new IllegalArgumentException("size는 1 이상 50 이하만 허용됩니다.");
        }

        //추후 enum으로 빼면 좋을까?
        if (filters != null) {
            for (String f : filters) {
                if (!f.equals("FAVORITE") && !f.equals("ZERO_STOCK")) {
                    throw new IllegalArgumentException("filters에는 FAVORITE 또는 ZERO_STOCK 만 허용됩니다.");
                }
            }
        }

        if (keyword != null && keyword.isBlank()) {
            keyword = null;
        } else if (keyword != null) {
            keyword = keyword.trim();
        }

        int offset = (page - 1) * size;
        long totalElements = itemMapper.countItemList(storeId,filters,keyword);
        List<ItemListDTO> content = itemMapper.findItemList(storeId, filters,keyword, offset, size);
        int totalPages = (int) Math.ceil(((double) totalElements / size));

        return new PageResponseDTO<>(content, page, size, totalElements, totalPages);

    }
}
