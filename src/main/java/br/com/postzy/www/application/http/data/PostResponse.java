package br.com.postzy.www.application.http.data;

import java.time.LocalDateTime;
import java.util.UUID;

public record PostResponse(
        String title,
        String content,
        String slug,
        String createdAt,
        String updatedAt,
        String publishedAt) {
}
