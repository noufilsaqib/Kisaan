package com.code.hackathon.dataServices;

import com.code.hackathon.dataInterfaceSQL.CropDiseaseRepository;
import com.code.hackathon.entities.CropDisease;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropDiseaseService {

    private final CropDiseaseRepository repository;

    public CropDiseaseService(CropDiseaseRepository repository) {
        this.repository = repository;
    }

    public List<CropDisease> findAll() {
        return repository.findAll();
    }

    public Optional<CropDisease> findById(Long id) {
        return repository.findById(id);
    }

    public CropDisease save(CropDisease cropDisease) {
        return repository.save(cropDisease);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
