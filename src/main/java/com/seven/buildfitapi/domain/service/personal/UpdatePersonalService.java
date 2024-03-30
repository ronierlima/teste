package com.seven.buildfitapi.domain.service.personal;

import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.domain.repository.PersonalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePersonalService {
    private final PersonalRepository personalRepository;

    public Personal update(Personal personal) {

        if(personal.getCode() == null) {
            throw new RuntimeException("Update only code");
        }

        if(personal.getId() == null) {
            throw new RuntimeException("Update only id");
        }

        return personalRepository.save(personal);
    }

}
