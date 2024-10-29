package com.code.hackathon;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code.hackathon.entities.CropDisease;

public interface CropDiseaseRepository extends JpaRepository<CropDisease, Long> {

}
