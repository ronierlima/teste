package com.seven.buildfitapi.domain.service.client;

import com.seven.buildfitapi.domain.model.Client;
import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.domain.repository.ClientRepository;
import com.seven.buildfitapi.domain.repository.PersonalRepository;
import com.seven.buildfitapi.domain.service.personal.GetPersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateClientService {
    private final ClientRepository clientRepository;

    public Client update(Client client) {

        if(client.getCode() == null || client.getId() == null) {
            throw new RuntimeException("Update only identificate");
        }

        return clientRepository.save(client);
    }

}
