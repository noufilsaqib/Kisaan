package com.code.hackathon.dataInterfaceSQL;

import com.code.hackathon.entities.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Long> {
}
