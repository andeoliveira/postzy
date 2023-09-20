package br.com.postzy.www.application.http.data;

public record CategoryResponse(
        String title,
        String content,
        String slug,
        String metaKeywords,
        String metaDescription,
        String createdAt,
        String updatedAt,
        String publishedAt) {
}
