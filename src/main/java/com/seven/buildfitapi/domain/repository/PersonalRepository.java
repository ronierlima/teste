package com.seven.buildfitapi.domain.repository;

import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.infra.repository.CustomJpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalRepository extends CustomJpaRepository<Personal, Long> {
}
