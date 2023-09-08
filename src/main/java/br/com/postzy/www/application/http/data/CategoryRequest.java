package br.com.postzy.www.application.http.data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CategoryRequest(
        @NotNull
        @NotEmpty
        String title,
        String content
) {
}
