package com.seven.buildfitapi.infra.repository.spec;

import com.seven.buildfitapi.domain.filter.ClientFilter;
import com.seven.buildfitapi.domain.model.Client;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class ClientSpecs {
    public static Specification<Client> usingFilter(ClientFilter filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getName() != null) {
                predicates.add(builder.like(builder.lower(root.get("name")), "%" + filter.getName().toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
