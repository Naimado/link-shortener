package com.example.linkshortener.controller;

import com.example.linkshortener.LinkDto;

import java.time.LocalDate;

record CreateLinkDto(String id,
                     String email,
                     String targetUrl,
                     LocalDate expirationDate) {

    LinkDto toDto() {
        return new LinkDto(id, email,targetUrl,expirationDate,0
                );
    }
}
