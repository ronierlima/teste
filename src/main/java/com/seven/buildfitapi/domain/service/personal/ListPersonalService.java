package com.seven.buildfitapi.domain.service.personal;

import com.seven.buildfitapi.domain.filter.PersonalFilter;
import com.seven.buildfitapi.domain.model.Personal;
import com.seven.buildfitapi.domain.repository.PersonalRepository;
import com.seven.buildfitapi.infra.repository.spec.PersonalSpecs;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ListPersonalService {

    private final PersonalRepository personalRepository;

    public List<Personal> listAll(PersonalFilter personalFilter) {
        return personalRepository.findAll(PersonalSpecs.usingFilter(personalFilter));
    }

    public Page<Personal> list(PersonalFilter personalFilter, Pageable pageable) {
       return personalRepository.findAll(PersonalSpecs.usingFilter(personalFilter), pageable);
    }

}
