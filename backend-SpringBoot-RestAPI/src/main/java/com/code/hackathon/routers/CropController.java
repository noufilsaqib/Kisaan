package com.code.hackathon.routers;

import com.code.hackathon.dataServices.CropDiseaseService;
import com.code.hackathon.entities.Crop;
import com.code.hackathon.dataServices.CropService;
import com.code.hackathon.entities.CropDisease;
import com.code.hackathon.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    @Autowired
    private CropService cropService;

    @Autowired
    CropDiseaseService cropDiseaseService;

    @GetMapping
    public List<Crop> getAllCrops() {
        return cropService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Crop> getCropById(@PathVariable Long id) {
        return cropService.findById(id);
    }

    @PostMapping
    public Crop addCrop(@RequestBody Crop crop) {
        crop.getDiseases().forEach(disease -> disease.setCrop(crop));
        return cropService.save(crop);
    }


    @PutMapping("/{id}")
    public Crop updateCrop(@PathVariable Long id, @RequestBody Crop crop) {
        crop.setId(id);
        return cropService.save(crop);
    }

    @DeleteMapping("/{id}")
    public void deleteCrop(@PathVariable Long id) {
        cropService.deleteById(id);
    }

    @PostMapping("/add-to-crop/{cropId}")
    public CropDisease addDiseaseToCrop(@PathVariable Long cropId, @RequestBody CropDisease cropDisease) {
        Crop crop = cropService.findById(cropId).orElseThrow(() -> new ResourceNotFoundException("Crop not found"));
        cropDisease.setCrop(crop);

        return cropDiseaseService.save(cropDisease);
    }

}
