package com.seven.buildfitapi.domain.service.personal;

import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.domain.repository.PersonalRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePersonalService {
    private final PersonalRepository personalRepository;
    private final GetPersonalService getPersonalService;

    public Personal save(Personal personal) {

        if(personal.getId() != null) {
            throw new RuntimeException("Create only no id");
        }

        if(personal.getCode() != null) {
            throw new RuntimeException("Create only no code");
        }

        if(getPersonalService.findByLicense(personal.getLicense()) != null) {
            throw new RuntimeException("License in used");
        }

        return personalRepository.save(personal);
    }

}
