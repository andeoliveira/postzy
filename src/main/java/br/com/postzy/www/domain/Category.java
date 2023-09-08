package br.com.postzy.www.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Category(
        UUID id,
        UUID parenteId,
        String title,
        String metaTitle,
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
        this(null, null, title, null, slug, content, null, null, null);
    }
}
