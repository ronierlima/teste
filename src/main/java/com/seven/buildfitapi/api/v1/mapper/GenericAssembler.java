package com.seven.buildfitapi.api.v1.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GenericAssembler {

    private final ModelMapper modelMapper;

    public <T, U> U toModel(T entity, Class<U> modelClass) {
        return modelMapper.map(entity, modelClass);
    }

    public <T, U> List<U> toCollectionModel(List<T> entities, Class<U> modelClass) {
        return entities.stream().map(entity -> toModel(entity, modelClass)).collect(Collectors.toList());
    }

}
