package com.seven.buildfitapi.domain.repository;

import com.seven.buildfitapi.domain.model.Client;
import com.seven.buildfitapi.infra.repository.CustomJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends CustomJpaRepository<Client, Long> {

    Optional<Client> findByCode(UUID code);
 }
