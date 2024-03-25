package com.seven.buildfitapi.domain.model;

import jakarta.persistence.Entity;

@Entity
public class Exercise extends Base {

    private String name;
    private String description;
    private String weight;
    private String series;
    private String interval;
    private String animation;
    //private List<MuscleModel> muscleGroups;
}
