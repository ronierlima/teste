package com.seven.buildfitapi.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonalInput {
    private String name;
    private LocalDate birthDate;
    private String license;

}
