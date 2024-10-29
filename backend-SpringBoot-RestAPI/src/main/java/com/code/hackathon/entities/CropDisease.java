package com.code.hackathon.entities;

import jakarta.persistence.*;

@Entity
public class CropDisease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String symptoms;

    @ManyToOne
    @JoinColumn(name = "crop_id") // Foreign key to refer to Crop
    private Crop crop;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public void setCrop(Crop rice) { this.crop = rice;}
}
