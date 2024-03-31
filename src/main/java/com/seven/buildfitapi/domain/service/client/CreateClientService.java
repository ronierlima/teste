package com.seven.buildfitapi.domain.service.client;

import com.seven.buildfitapi.domain.model.Client;
import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.domain.repository.ClientRepository;
import com.seven.buildfitapi.domain.service.personal.GetPersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateClientService {
    private final ClientRepository clientRepository;
    private final GetPersonalService getPersonalService;

    public Client save(Client client) {

        if(client.getId() != null) {
            throw new RuntimeException("Create only no id");
        }

        if(client.getCode() != null) {
            throw new RuntimeException("Create only no code");
        }

        fetchAndPopulateRelatedData(client);

        return clientRepository.save(client);
    }

    private void fetchAndPopulateRelatedData(Client client) {

        if(client.getPersonal() != null) {
            Personal personal = getPersonalService.findByCode(client.getPersonal().getCode());
            client.setPersonal(personal);
        }
    }

}
