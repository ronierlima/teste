package com.seven.buildfitapi.domain.service.client;

import com.seven.buildfitapi.domain.model.Client;
import com.seven.buildfitapi.domain.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetClientService {

    private final ClientRepository clientRepository;

    public Client findByCode(UUID code) {
        return clientRepository.findByCode(code).orElseThrow(() -> new EntityNotFoundException("Client not found"));
    }

    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client not found"));
    }

}
