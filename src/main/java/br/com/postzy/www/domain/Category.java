package br.com.postzy.www.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Category(
        UUID id,
        UUID parenteId,
        String title,
        String slug,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime publishedAt
) {
    public Category(
            String title,
            String content,
            String slug
    ) {
        this(null, null, title, slug, content, null, null, null);
    }

    public Category(
            String title,
            String content,
            String slug,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            LocalDateTime publishedAt
    ) {
        this(null, null, title, content, slug, createdAt, updatedAt, publishedAt);
    }
}
