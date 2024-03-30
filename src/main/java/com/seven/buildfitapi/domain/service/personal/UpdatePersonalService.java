package com.seven.buildfitapi.domain.service.personal;

import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.domain.repository.PersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePersonalService {
    private final PersonalRepository personalRepository;
    private final GetPersonalService getPersonalService;

    public Personal update(Personal personal) {

        if(personal.getCode() == null) {
            throw new RuntimeException("Update only code");
        }

        if(personal.getId() == null) {
            throw new RuntimeException("Update only id");
        }

        Personal personalSearchByLicense = getPersonalService.findByLicense(personal.getLicense());

        if(personalSearchByLicense != null && !personalSearchByLicense.getCode().equals(personal.getCode())) {
            throw new RuntimeException("License in used");
        }

        return personalRepository.save(personal);
    }

}
