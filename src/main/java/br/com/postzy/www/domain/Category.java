package br.com.postzy.www.domain;

import java.util.UUID;

public record Category(
        UUID id,
        String name,
        String description
) {
}
