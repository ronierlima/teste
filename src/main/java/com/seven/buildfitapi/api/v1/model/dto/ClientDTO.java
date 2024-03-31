package com.seven.buildfitapi.api.v1.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO extends PersonDTO {

    private BaseCodeDTO personal;
}
