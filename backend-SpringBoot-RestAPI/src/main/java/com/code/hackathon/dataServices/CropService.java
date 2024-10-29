package com.code.hackathon.dataServices;

import com.code.hackathon.dataInterfaceSQL.CropRepository;
import com.code.hackathon.entities.Crop;
import com.code.hackathon.entities.CropDisease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    // for one time test-use
    @Transactional
    public void addCropWithDiseases() {
        Crop rice = new Crop();
        rice.setName("Rice");

        CropDisease blast = new CropDisease();
        blast.setName("Blast");
        blast.setDescription("Fungal disease affecting rice.");
        blast.setSymptoms("Lesions on leaves, reduced yield.");
        blast.setCrop(rice);

        CropDisease sheathBlight = new CropDisease();
        sheathBlight.setName("Sheath Blight");
        sheathBlight.setDescription("Disease caused by Rhizoctonia solani.");
        sheathBlight.setSymptoms("Water-soaked lesions on leaves.");
        sheathBlight.setCrop(rice);

        rice.setDiseases(Arrays.asList(blast, sheathBlight));

        cropRepository.save(rice);
    }

    public List<Crop> findAll() {
        return cropRepository.findAll();
    }

    public Optional<Crop> findById(Long id) {
        return cropRepository.findById(id);
    }

    public Crop save(Crop crop) {
        return cropRepository.save(crop);
    }

    public void deleteById(Long id) {
        cropRepository.deleteById(id);
    }
}
