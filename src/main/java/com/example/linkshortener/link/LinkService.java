package com.example.linkshortener.link;

import com.example.linkshortener.LinkDto;

public interface LinkService {

    LinkDto createLink(LinkDto toDto);

    LinkDto getLinkAndIncrementVisits(String id);

}
