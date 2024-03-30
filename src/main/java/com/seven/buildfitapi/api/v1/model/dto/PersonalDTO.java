package com.seven.buildfitapi.api.v1.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class PersonalDTO {
    private String name;
    private UUID code;
    private String license;
    private LocalDate birthDate;
}
