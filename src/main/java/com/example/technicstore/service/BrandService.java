package com.example.technicstore.service;

import com.example.technicstore.entity.Brand;
import com.example.technicstore.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Optional<Brand> getBrandById(Long id) {
        return brandRepository.findById(id);
    }

    public List<Brand> getBrandByNameContaining(String name) {
        return brandRepository.findBrandByNameContainingIgnoreCase(name);
    }
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand updateBrand(Long id, Brand updatedBrand) {
        Optional<Brand> brandOptional = brandRepository.findById(id);
        if (brandOptional.isPresent()) {
            Brand existingBrand = brandOptional.get();
            existingBrand.setName(updatedBrand.getName());
            return brandRepository.save(existingBrand);
        }
        return null;
    }

    public void deleteBrand(Long id) {
        brandRepository.deleteById(id);
    }
}
