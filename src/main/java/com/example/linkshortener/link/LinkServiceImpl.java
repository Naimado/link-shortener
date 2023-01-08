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
    public LinkDto getLinkAndIncrementVisits(final String id) {
        if(linkRepository.findById(id).isEmpty()){
            throw new RuntimeException();
        }
        LinkEntity linkEntity=linkRepository.findById(id).get();
        linkEntity.setVisits(linkEntity.visits+1);
        return linkRepository.save(linkEntity).toDto();
    }

}
