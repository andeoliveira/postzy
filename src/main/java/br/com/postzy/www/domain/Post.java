package br.com.postzy.www.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Post(
        UUID id,
        String title,
        String content,
        String slug,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime publishedAt) {

    public Post(
            String title,
            String content,
            String slug) {
        this(null, title, content, slug, null, null, null);
    }

    public Post(
            String title,
            String content,
            String slug,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            LocalDateTime publishedAt) {
        this(null, title, content, slug, createdAt, updatedAt, publishedAt);
    }


}
