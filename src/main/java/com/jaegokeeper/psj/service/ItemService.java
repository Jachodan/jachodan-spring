package com.jaegokeeper.psj.service;

import com.jaegokeeper.psj.dto.ItemDto;
<<<<<<< HEAD
import com.jaegokeeper.psj.mapper.ItemMapper;
import com.jaegokeeper.psj.mapper.StoreMapper;
=======
import com.jaegokeeper.psj.entity.Item;
import com.jaegokeeper.psj.entity.Store;
import com.jaegokeeper.psj.repository.ItemRepository;
import com.jaegokeeper.psj.repository.StoreRepository;
>>>>>>> b6f50670bb624145e2ce410df835b0769fc70590
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
<<<<<<< HEAD
    private final StoreMapper storeMapper;
    private final ItemMapper itemMapper;

    public ItemService(StoreMapper storeMapper, ItemMapper itemMapper) {
        this.storeMapper = storeMapper;
        this.itemMapper = itemMapper;
    }

    // 저장 메서드
    public void saveDto(ItemDto dto) {
        // Store 존재 확인
        if(!storeMapper.existsById(String.valueOf(dto.getStoreId()))) {
            throw new IllegalArgumentException("Store가 존재하지 않습니다.");
        }

        // 아이템 이름 중복 체크
        if(itemMapper.existsByName(dto.getItemName())) {
            throw new IllegalArgumentException("존재하는 아이템 이름입니다.");
        }

        // 저장
        itemMapper.insertItem(dto);
    }

    // 전체 조회 메서드 (saveDto 밖에 독립적으로)
    public List<ItemDto> getAllItems() {
        return itemMapper.selectAllItems();
=======

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
>>>>>>> b6f50670bb624145e2ce410df835b0769fc70590
    }
}