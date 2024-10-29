package com.code.hackathon.dataInterfaceSQL;

import org.springframework.data.jpa.repository.JpaRepository;
import com.code.hackathon.entities.CropDisease;

public interface CropDiseaseRepository extends JpaRepository<CropDisease, Long> {

}

