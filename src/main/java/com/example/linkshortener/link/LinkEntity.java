package com.example.linkshortener.link;

import com.example.linkshortener.LinkDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

class LinkEntity {
    @Id
    String id;
    String email;
    String targetUrl;
    LocalDate expirationDate;
    int visits;

    static public LinkEntity fromDto(LinkDto linkDto){

        return LinkEntity.builder().id(linkDto.id())
                .email(linkDto.email())
                .targetUrl(linkDto.targetUrl())
                .expirationDate(linkDto.expirationDate())
                .visits(linkDto.visits())
                .build();
    }

    LinkDto toDto(){
        return new LinkDto(id,email,targetUrl,expirationDate,visits);
    }



}
