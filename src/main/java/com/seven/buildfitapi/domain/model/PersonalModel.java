package com.seven.buildfitapi.domain.model;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@EqualsAndHashCode(callSuper = true)
public class PersonalModel extends BaseModel {

    private String license;

    private List<ClientModel> clients;
    private List<ContactModel> contacts;
    private List<String> workouts;
}
