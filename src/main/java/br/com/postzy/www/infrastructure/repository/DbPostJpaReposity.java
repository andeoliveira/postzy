package br.com.postzy.www.infrastructure.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DbPostJpaReposity extends JpaRepository<PostEntity, UUID> {

    Page<PostEntity> findAll(Pageable pag);
}
