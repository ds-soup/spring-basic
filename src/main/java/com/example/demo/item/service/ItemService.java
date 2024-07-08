package com.example.demo.item.service;

import com.example.demo.item.dto.ItemRequestDto;
import com.example.demo.item.dto.ItemResponseDto;
import com.example.demo.item.entity.Item;
import com.example.demo.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemResponseDto write(ItemRequestDto requestDto) {
        Item item = new Item(requestDto);

        System.out.println(item.getContent());
        System.out.println(item.getUsername());

        itemRepository.save(item);

        ItemResponseDto itemResponseDto = new ItemResponseDto(item);
        return itemResponseDto;
    }

    public List<ItemResponseDto> read() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map(ItemResponseDto::new).toList();
    }

    public ItemResponseDto update(Long id, ItemRequestDto requestDto) throws IllegalArgumentException {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        if(!item.getUsername().equals(requestDto.getUsername())) {
            throw new IllegalArgumentException("게시글을 수정할 수 없습니다.");
        }

        item.setTitle(requestDto.getTitle());
        item.setContent(requestDto.getContent());
        item.setPrice(requestDto.getPrice());

        itemRepository.save(item);
        return new ItemResponseDto(item);
    }

    public String delete(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        itemRepository.delete(item);

        return "{\"msg\": \"삭제 완료\"}";

    }
}
