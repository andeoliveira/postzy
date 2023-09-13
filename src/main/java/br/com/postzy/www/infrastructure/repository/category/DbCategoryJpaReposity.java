package br.com.postzy.www.infrastructure.repository.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DbCategoryJpaReposity extends JpaRepository<CategoryEntity, UUID> {
    Page<CategoryEntity> findAll(Pageable pag);
}
