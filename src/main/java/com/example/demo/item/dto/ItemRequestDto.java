package com.example.demo.item.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemRequestDto {
    private String username;
    private String title;
    private String content;
    private Integer price;
}
