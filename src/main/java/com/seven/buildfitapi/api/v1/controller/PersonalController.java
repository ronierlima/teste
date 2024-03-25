package com.seven.buildfitapi.api.v1.controller;

import com.seven.buildfitapi.api.v1.mapper.GenericAssembler;
import com.seven.buildfitapi.api.v1.mapper.GenericDisassembler;
import com.seven.buildfitapi.api.v1.model.dto.PageDTO;
import com.seven.buildfitapi.api.v1.model.dto.PersonalDTO;
import com.seven.buildfitapi.api.v1.model.input.PersonalInput;
import com.seven.buildfitapi.domain.filter.PersonalFilter;
import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.domain.repository.PersonalRepository;
import com.seven.buildfitapi.domain.service.personal.CreatePersonalService;
import com.seven.buildfitapi.domain.service.personal.ListPersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/personals", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PersonalController {

    private final CreatePersonalService createPersonalService;
    private final ListPersonalService listPersonalService;

    private final GenericAssembler genericAssembler;
    private final GenericDisassembler genericDisassembler;

    @GetMapping
    public PageDTO<PersonalDTO> list(PersonalFilter personalFilter, Pageable pageable) {
        Page<Personal> personalsPage = listPersonalService.list(personalFilter, pageable);
        List<PersonalDTO> personalsDTOS = genericAssembler.toCollectionModel(personalsPage.getContent(), PersonalDTO.class);

        return new PageDTO<>(personalsDTOS, personalsPage.getPageable(), personalsPage.getTotalElements());
    }

    @GetMapping("/all")
    public List<PersonalDTO> listAll(PersonalFilter personalFilter) {
        List<Personal> personals = listPersonalService.listAll(personalFilter);
        return genericAssembler.toCollectionModel(personals, PersonalDTO.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalDTO create(@RequestBody PersonalInput personalInput) {
        Personal personal = genericDisassembler.toDomainObject(personalInput, Personal.class);
        Personal personal1 = createPersonalService.save(personal);

        return genericAssembler.toModel(personal1, PersonalDTO.class);
    }

}
