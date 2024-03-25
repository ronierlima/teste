package com.seven.buildfitapi.api.v1.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Data
@AllArgsConstructor
public class PageDTO<T> {
    private List<T> content;
    @JsonIgnore
    private Pageable pageable;
    private Long total;

    public int getTotalPages() {
        return getSize() == 0 ? 1 : (int) Math.ceil((double) total / (double) getSize());
    }

    public int getSize() {
        return pageable.isPaged() ? pageable.getPageSize() : 0;
    }

    public int getCurrentPage() {
        return pageable.isPaged() ? pageable.getPageNumber() : 0;
    }

}
