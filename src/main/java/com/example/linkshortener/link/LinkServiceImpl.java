package com.example.linkshortener.link;

import com.example.linkshortener.LinkDto;
import org.springframework.stereotype.Service;

@Service
class LinkServiceImpl implements LinkService {

    public final LinkRepository linkRepository;

    LinkServiceImpl(final LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }


    @Override
    public LinkDto createLink(final LinkDto toDto) {
        //TODO jakas walidacja?
        linkRepository.save(LinkEntity.fromDto(toDto));
        return toDto;
    }

    @Override
    public LinkDto getLink(final String id) {
        return linkRepository.findById(id).get().toDto();
    }


}
