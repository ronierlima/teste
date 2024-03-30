package com.seven.buildfitapi.domain.repository;

import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
