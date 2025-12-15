package com.jaegokeeper.hwan.controller;

import com.jaegokeeper.hwan.dto.ItemCreateRequestDTO;
import com.jaegokeeper.hwan.dto.ItemCreateResponseDTO;
import com.jaegokeeper.hwan.dto.ItemListDTO;
import com.jaegokeeper.hwan.dto.PageResponseDTO;
import com.jaegokeeper.hwan.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<ItemCreateResponseDTO> createItem(@Valid @RequestBody ItemCreateRequestDTO itemCreateRequestDTO) {


        Integer itemId = itemService.registerItem(itemCreateRequestDTO);

        return ResponseEntity
                .status(201)
                .body(new ItemCreateResponseDTO(itemId));
    }

    @GetMapping
    public ResponseEntity<PageResponseDTO<ItemListDTO>> getItems(
            @RequestParam Integer storeId,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) List<String> filters,
            @RequestParam(required = false) String keyword
    ) {
        return ResponseEntity.ok(itemService.getItemList(storeId, page, size, filters,keyword));
    }
}
