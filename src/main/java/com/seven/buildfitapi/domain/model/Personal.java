package com.seven.buildfitapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "personals")
@DiscriminatorValue("PERSONAL")
public class Personal extends Person {

    private String license;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personal")
    private List<Client> clients;
}
