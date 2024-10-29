package com.code.hackathon.routers;

import com.code.hackathon.entities.CropDisease;
import com.code.hackathon.dataServices.CropDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/crop-diseases")
public class CropDiseaseController {

    // test route (HELLO WORLD)
    @GetMapping("/hello")
    public Map<String, String> sayHello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, Hackathon!");
        return response;
    }

    // ----------------------- CROP DISEASE CRUD OPERATIONS BELOW -------------------
    @Autowired
    private CropDiseaseService cropDiseaseService;

    @GetMapping
    public List<CropDisease> getAllDiseases() {
        return cropDiseaseService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CropDisease> getDiseaseById(@PathVariable Long id) {
        return cropDiseaseService.findById(id);
    }

    @PostMapping
    public CropDisease addDisease(@RequestBody CropDisease cropDisease) {
        return cropDiseaseService.save(cropDisease);
    }

    @PutMapping("/{id}")
    public CropDisease updateDisease(@PathVariable Long id, @RequestBody CropDisease cropDisease) {
        cropDisease.setId(id);
        return cropDiseaseService.save(cropDisease);
    }

    @DeleteMapping("/{id}")
    public void deleteDisease(@PathVariable Long id) {
        cropDiseaseService.deleteById(id);
    }

    // ---------------------------------------------------------------------------------------


}
