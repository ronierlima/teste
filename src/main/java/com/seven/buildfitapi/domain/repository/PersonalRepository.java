package com.seven.buildfitapi.domain.repository;

import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.infra.repository.CustomJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonalRepository extends CustomJpaRepository<Personal, Long> {

    Optional<Personal> findByCode(UUID code);
    Optional<Personal> findByLincese(String lincese);
}
