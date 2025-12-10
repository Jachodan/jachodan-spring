package com.jaegokeeper.psj.service;

import com.jaegokeeper.psj.dto.ItemDto;
import com.jaegokeeper.psj.entity.Item;
import com.jaegokeeper.psj.entity.Store;
import com.jaegokeeper.psj.repository.ItemRepository;
import com.jaegokeeper.psj.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final StoreRepository storeRepository;

    // 생성자 주입
    public ItemService(ItemRepository itemRepository, StoreRepository storeRepository) {
        this.itemRepository = itemRepository;
        this.storeRepository = storeRepository;
    }

    public void saveItem(ItemDto dto) {
        // Store 가져오기
        Store store = storeRepository.findById(dto.getStoreId()).get();

        // Item 만들기
        Item entity = new Item();
        entity.setStore(store);  // Store 객체 설정
        entity.setItemName(dto.getItemName());
        // createdAt과 delYn은 @PrePersist에서 자동 설정됨

        // 저장
        itemRepository.save(entity);
    }
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}