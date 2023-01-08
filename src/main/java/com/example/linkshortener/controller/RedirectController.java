package com.example.linkshortener.controller;

import com.example.linkshortener.LinkDto;
import com.example.linkshortener.link.LinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/s")
class RedirectController {


    private final LinkService linkService;

    RedirectController(final LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("/{id}")
    public void redirectLink(
            @PathVariable String id, HttpServletResponse httpServletResponse) throws IOException {
        final LinkDto linkDto = linkService.getLinkAndIncrementVisits(id);
        httpServletResponse.sendRedirect(linkDto.targetUrl());

    }


}
