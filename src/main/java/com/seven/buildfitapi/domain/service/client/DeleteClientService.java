package com.seven.buildfitapi.domain.service.client;

import com.seven.buildfitapi.domain.model.Client;
import com.seven.buildfitapi.domain.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteClientService {
    private final ClientRepository clientRepository;

    private final GetClientService getPersonalService;


    public void delete(UUID code) {

        Client client = getPersonalService.findByCode(code);

        client.setActive(false);

        clientRepository.save(client);
    }

}
