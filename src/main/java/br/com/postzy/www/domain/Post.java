package br.com.postzy.www.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public record Post(
        UUID id,
        String title,
        String content,
        String slug,
        String metaKeywords,
        String metaDescription,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime publishedAt) {

    public Post(
            String title,
            String content,
            String slug,
            String metaKeywords,
            String metaDescription) {
        this(null, title, content, slug, metaKeywords, metaDescription, null, null, null);
    }

    public Post(
            String title,
            String content,
            String slug,
            String metaKeywords,
            String metaDescription,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            LocalDateTime publishedAt) {
        this(null, title, content, slug, metaKeywords, metaDescription, createdAt, updatedAt, publishedAt);
    }


}
