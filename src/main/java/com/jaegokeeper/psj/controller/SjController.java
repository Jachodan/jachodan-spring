package com.jaegokeeper.psj.controller;

import com.jaegokeeper.psj.dto.ItemDto;
import com.jaegokeeper.psj.entity.Item;
import com.jaegokeeper.psj.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SjController {
    // Service 호출
    private  final ItemService itemService;

    // (생성자 주입)
    public SjController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/sj")
    public String mapRequest(@RequestBody ItemDto item) {
        itemService.saveItem(item);
        return "ok";
    }

    @GetMapping("/sj")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
}
