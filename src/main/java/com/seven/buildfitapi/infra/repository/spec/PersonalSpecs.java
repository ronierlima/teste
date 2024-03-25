package com.seven.buildfitapi.infra.repository.spec;

import com.seven.buildfitapi.domain.filter.PersonalFilter;
import com.seven.buildfitapi.domain.model.Personal;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PersonalSpecs {
    public static Specification<Personal> usingFilter(PersonalFilter filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getName() != null) {
                predicates.add(builder.like(builder.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
