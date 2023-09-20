package br.com.postzy.www.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Category(
        UUID id,
        UUID parenteId,
        String title,
        String slug,
        String metaKeywords,
        String metaDescription,
        String content,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime publishedAt
) {
    public Category(
            String title,
            String content,
            String slug,
            String metaKeywords,
            String metaDescription
    ) {
        this(null, null, content, title, slug, metaKeywords, metaDescription, null, null, null);
    }

    public Category(
            String title,
            String content,
            String slug,
            String metaKeywords,
            String metaDescription,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            LocalDateTime publishedAt
    ) {
        this(null, null, title, content, slug, metaKeywords, metaDescription, createdAt, updatedAt, publishedAt);
    }
}
