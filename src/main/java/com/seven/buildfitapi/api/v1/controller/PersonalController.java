package com.seven.buildfitapi.api.v1.controller;

import com.seven.buildfitapi.api.v1.mapper.GenericAssembler;
import com.seven.buildfitapi.api.v1.mapper.GenericDisassembler;
import com.seven.buildfitapi.api.v1.model.dto.PageDTO;
import com.seven.buildfitapi.api.v1.model.dto.PersonalDTO;
import com.seven.buildfitapi.api.v1.model.input.PersonalInput;
import com.seven.buildfitapi.domain.filter.PersonalFilter;
import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.domain.service.personal.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "v1/personals", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PersonalController {

    private final CreatePersonalService createPersonalService;
    private final UpdatePersonalService updatePersonalService;
    private final DeletePersonalService deletePersonalService;
    private final ListPersonalService listPersonalService;
    private final GetPersonalService getPersonalService;

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

    @GetMapping("/{code}")
    public PersonalDTO findByCode(@PathVariable UUID code) {
        Personal personal = getPersonalService.findByCode(code);

        return genericAssembler.toModel(personal, PersonalDTO.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonalDTO create(@RequestBody PersonalInput personalInput) {
        Personal personal = genericDisassembler.toDomainObject(personalInput, Personal.class);
        Personal personalSaved = createPersonalService.save(personal);

        return genericAssembler.toModel(personalSaved, PersonalDTO.class);
    }

    @PutMapping("/{code}")
    public PersonalDTO update(@PathVariable UUID code, @RequestBody PersonalInput personalInput) {
        Personal personalSearch = getPersonalService.findByCode(code);

        genericDisassembler.copyToDomainObject(personalInput, personalSearch);

        Personal personalSaved = updatePersonalService.update(personalSearch);

        return genericAssembler.toModel(personalSaved, PersonalDTO.class);
    }

    @DeleteMapping("/{code}")
    public void delete(@PathVariable UUID code) {
        deletePersonalService.delete(code);
    }


}
