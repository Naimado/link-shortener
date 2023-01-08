package com.example.linkshortener;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
@Schema(description = "Identifier/alias to link. Used for redirection.", example = "link-alias", required = true)
record LinkDto(
         String id,
         String email,
         String targetUrl,
         LocalDate expirationDate,
         int visits) {

}
