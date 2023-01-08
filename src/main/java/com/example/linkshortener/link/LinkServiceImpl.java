package com.example.linkshortener.link;

import com.example.linkshortener.LinkDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.beans.Transient;

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
    @Transactional
    public LinkDto getLinkAndIncrementVisits(final String id) {
        final LinkEntity linkEntity=linkRepository.findById(id).orElseThrow(()->new LinkNotFoundException(id));
        linkEntity.setVisits(linkEntity.getVisits()+1);
        return linkEntity.toDto();
    }

}
