package com.example.demo.item.controller;

import com.example.demo.item.dto.ItemRequestDto;
import com.example.demo.item.dto.ItemResponseDto;
import com.example.demo.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemApiController {

    private final ItemService itemService;

    @GetMapping("/post")
    public ItemResponseDto write(@RequestBody ItemRequestDto requestDto) {
        return itemService.write(requestDto);
    }

    @PostMapping("/post")
    public List<ItemResponseDto> read() {
        return itemService.read();
    }

    @PutMapping("/post/{id}")
    public ItemResponseDto update(@PathVariable Long id, @RequestBody ItemRequestDto requestDto) {
        return itemService.update(id, requestDto);
    }

    @DeleteMapping("/post/{id}")
    public String delete(@PathVariable Long id) {
        return itemService.delete(id);
    }
}
