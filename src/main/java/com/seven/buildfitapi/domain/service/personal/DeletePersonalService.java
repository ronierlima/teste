package com.seven.buildfitapi.domain.service.personal;

import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.domain.repository.PersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeletePersonalService {
    private final PersonalRepository personalRepository;

    private final GetPersonalService getPersonalService;


    public void delete(UUID code) {

        Personal personal = getPersonalService.findByCode(code);

        personal.setActive(false);

        personalRepository.save(personal);
    }

}
