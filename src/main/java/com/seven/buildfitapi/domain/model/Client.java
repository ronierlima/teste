package com.seven.buildfitapi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "clients")
public class Client extends Person {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_id")
    private Personal personal;
}
