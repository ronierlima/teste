package com.seven.buildfitapi.api.v1.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenericDisassembler {

    private final ModelMapper modelMapper;

    public <T, U> U toDomainObject(T entity, Class<U> modelClass) {
        return modelMapper.map(entity, modelClass);
    }

    public <T, U> void copyToDomainObject(T input, U domainObject) {

        modelMapper.map(input, domainObject);
    }
}

