package com.seven.buildfitapi.api.v1.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRegisterInput extends PersonInput {

    PersonCodeInput personal;
}
