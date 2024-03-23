package com.seven.buildfitapi.domain.model;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = true)
public class UserModel extends BaseModel{

    private String name;
    private String email;
    private String password;

    private Boolean subscriber;
    private String identityAccount;
    private Boolean personal;
}
