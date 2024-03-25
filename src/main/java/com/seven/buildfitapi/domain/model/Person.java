package com.seven.buildfitapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Inheritance( strategy = InheritanceType.JOINED )
public class Person extends Base {

    private String name;
    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private List<Contact> contacts;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "person")
    private User user;
}
