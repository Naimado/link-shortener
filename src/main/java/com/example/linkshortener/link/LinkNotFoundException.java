package com.example.linkshortener.link;

class LinkNotFoundException extends RuntimeException{
    LinkNotFoundException(final String id){
        super("Link with id: "+id+" not found.");
    }

}
