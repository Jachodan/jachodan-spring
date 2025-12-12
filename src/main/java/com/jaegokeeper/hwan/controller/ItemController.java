package com.jaegokeeper.hwan.controller;

import com.jaegokeeper.hwan.dto.ItemCreateRequestDTO;
import com.jaegokeeper.hwan.dto.ItemCreateResponseDTO;
import com.jaegokeeper.hwan.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}
