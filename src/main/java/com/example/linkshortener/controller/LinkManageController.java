package com.example.linkshortener.controller;

import com.example.linkshortener.LinkDto;
import com.example.linkshortener.link.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/links")
@AllArgsConstructor
class LinkManageController {


    private final LinkService linkService;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    LinkDto createLink(@RequestBody CreateLinkDto link){
        return linkService.createLink(link.toDto());
    }
}
