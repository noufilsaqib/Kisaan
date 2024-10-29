package com.code.hackathon.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CropDisease> diseases;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public void setDiseases(List<CropDisease> diseases) {
        this.diseases = diseases;
        for (CropDisease disease : diseases) {
            disease.setCrop(this);  // Set the crop reference in each disease
        }
    }

    public List<CropDisease> getDiseases() {
        return diseases;
    }
}
