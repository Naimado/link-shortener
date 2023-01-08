package com.example.linkshortener;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
@Schema(description = "Identifier/alias to link. Used for redirection.", example = "link-alias", required = true)
public
record LinkDto(
         String id,
         String email,
         String targetUrl,
         LocalDate expirationDate,
         int visits) {

    //??
    public LinkDto visitsIncrease(){
        int newVisitsCounter;
        LinkDto temp=new LinkDto(id,email,targetUrl,expirationDate,visits+1);
        return temp;
    }
    public String getShortenedLink() {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/s/{id}")
                .buildAndExpand(id)
                .toUriString();
    }
}
