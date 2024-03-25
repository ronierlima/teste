package com.seven.buildfitapi.api.v1.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonalDTO {
    private String name;
    private String license;
    private LocalDate birthDate;
}
