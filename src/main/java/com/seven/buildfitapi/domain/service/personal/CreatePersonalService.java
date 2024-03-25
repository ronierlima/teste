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

    public Personal save(Personal personal) {
        return personalRepository.save(personal);
    }

}
