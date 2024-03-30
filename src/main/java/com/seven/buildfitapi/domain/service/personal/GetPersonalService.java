package com.seven.buildfitapi.domain.service.personal;

import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.domain.repository.PersonalRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetPersonalService {

    private final PersonalRepository personalRepository;

    public Personal findByCode(UUID code) {
        return personalRepository.findByCode(code).orElseThrow(() -> new EntityNotFoundException("Personal not found"));
    }

    public Personal findById(Long id) {
        return personalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Personal not found"));
    }

    public Personal findByLicense(String license) {
        return personalRepository.findByLicense(license).orElse(null);
    }

}
