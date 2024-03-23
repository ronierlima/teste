package com.seven.buildfitapi.domain.model;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class ExerciseModel extends BaseModel{

    private String name;
    private String description;
    private String weight;
    private String series;
    private String interval;
    private String animation;
    //private List<MuscleModel> muscleGroups;
}
