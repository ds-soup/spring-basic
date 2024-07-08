package com.example.demo.item.dto;

import com.example.demo.item.entity.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponseDto {
    private String username;
    private String title;
    private String content;
    private Integer price;

    public ItemResponseDto(Item item) {
        this.username = item.getUsername();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
    }
}
