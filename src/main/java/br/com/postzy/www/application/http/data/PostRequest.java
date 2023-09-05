package br.com.postzy.www.application.http.data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PostRequest(
        @NotNull
        @NotEmpty
        String title,
        @NotNull
        String content
) {
}
