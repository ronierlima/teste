package com.seven.buildfitapi.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "users")
@Data
public class User extends Base {

    private String email;
    private String password;

    private Boolean subscriber;
    private String identityAccount;

    @OneToOne()
    @JoinColumn(name = "person_id")
    private Person person;
}
