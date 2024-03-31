package com.seven.buildfitapi.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class PersonCodeInput {
    private UUID code;
}
