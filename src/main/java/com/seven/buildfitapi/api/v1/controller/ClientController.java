package com.seven.buildfitapi.api.v1.controller;

import com.seven.buildfitapi.api.v1.mapper.GenericAssembler;
import com.seven.buildfitapi.api.v1.mapper.GenericDisassembler;
import com.seven.buildfitapi.api.v1.model.dto.ClientDTO;
import com.seven.buildfitapi.api.v1.model.dto.PageDTO;
import com.seven.buildfitapi.api.v1.model.input.ClientInput;
import com.seven.buildfitapi.api.v1.model.input.ClientRegisterInput;
import com.seven.buildfitapi.domain.filter.ClientFilter;
import com.seven.buildfitapi.domain.model.Client;
import com.seven.buildfitapi.domain.service.client.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "v1/clients", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ClientController {

    private final CreateClientService createClientService;
    private final UpdateClientService updateClientService;
    private final DeleteClientService deleteClientService;
    private final ListClientService listClientService;
    private final GetClientService getClientService;

    private final GenericAssembler genericAssembler;
    private final GenericDisassembler genericDisassembler;

    @GetMapping
    public PageDTO<ClientDTO> list(ClientFilter clientFilter, Pageable pageable) {
        Page<Client> personalsPage = listClientService.list(clientFilter, pageable);
        List<ClientDTO> personalsDTOS = genericAssembler.toCollectionModel(personalsPage.getContent(), ClientDTO.class);

        return new PageDTO<>(personalsDTOS, personalsPage.getPageable(), personalsPage.getTotalElements());
    }

    @GetMapping("/all")
    public List<ClientDTO> listAll(ClientFilter personalFilter) {
        List<Client> personals = listClientService.listAll(personalFilter);

        return genericAssembler.toCollectionModel(personals, ClientDTO.class);
    }

    @GetMapping("/{code}")
    public ClientDTO findByCode(@PathVariable UUID code) {
        Client client = getClientService.findByCode(code);

        return genericAssembler.toModel(client, ClientDTO.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientDTO create(@RequestBody ClientRegisterInput clientInput) {
        Client client = genericDisassembler.toDomainObject(clientInput, Client.class);
        Client clientSaved = createClientService.save(client);

        return genericAssembler.toModel(clientSaved, ClientDTO.class);
    }

    @PutMapping("/{code}")
    public ClientDTO update(@PathVariable UUID code, @RequestBody ClientInput clientInput) {
        Client clientSearch = getClientService.findByCode(code);

        genericDisassembler.copyToDomainObject(clientInput, clientSearch);

        Client clientSaved = updateClientService.update(clientSearch);

        return genericAssembler.toModel(clientSaved, ClientDTO.class);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable UUID code) {
        deleteClientService.delete(code);
    }


}
