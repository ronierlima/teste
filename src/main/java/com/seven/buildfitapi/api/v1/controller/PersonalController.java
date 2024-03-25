package com.seven.buildfitapi.api.v1.controller;

import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.domain.model.User;
import com.seven.buildfitapi.domain.repository.PersonalRepository;
import com.seven.buildfitapi.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/personals", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PersonalController {

    private final PersonalRepository personalRepository;
    private final UserRepository userRepository;

    @GetMapping
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Personal create(@RequestBody Personal personal) {
        return personalRepository.save(personal);
    }

}
