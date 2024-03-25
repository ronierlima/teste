package com.seven.buildfitapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "contacts")
public class Contact extends Base {

    private String identity;
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id" )
    private Person person;
}


