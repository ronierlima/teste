package com.seven.buildfitapi.domain.service.client;

import com.seven.buildfitapi.domain.filter.ClientFilter;
import com.seven.buildfitapi.domain.model.Client;
import com.seven.buildfitapi.domain.repository.ClientRepository;
import com.seven.buildfitapi.infra.repository.spec.ClientSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListClientService {

    private final ClientRepository clientRepository;

    public List<Client> listAll(ClientFilter clientFilter) {
        return clientRepository.findAll(ClientSpecs.usingFilter(clientFilter));
    }

    public Page<Client> list(ClientFilter clientFilter, Pageable pageable) {
       return clientRepository.findAll(ClientSpecs.usingFilter(clientFilter), pageable);
    }

}
