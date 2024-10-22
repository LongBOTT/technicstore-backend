package com.example.technicstore.service;

import com.example.technicstore.entity.Brand;
import com.example.technicstore.entity.Category;
import com.example.technicstore.entity.Product;
import com.example.technicstore.repository.BrandRepository;
import com.example.technicstore.repository.CategoryRepository;
import com.example.technicstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    public Optional<Brand> getBrandById(Long id) {
        return brandRepository.findById(id);
    }

    // Lấy danh sách thương hiệu theo tên chính xác
    public Optional<Brand> getBrandByName(String name) {
        return brandRepository.findBrandByName(name);
    }

    // Lấy danh sách thương hiệu theo tên chứa chuỗi name
    public List<Brand> getBrandByNameContaining(String name) {
        return brandRepository.findBrandByNameContainingIgnoreCase(name);
    }

    public List<Brand> getBrandsByCategory(String name) {
        Category category = categoryRepository.findCategoryByName(name).orElse(null);
        if (category!= null) {
            List<Product> products = productRepository.findProductsByCategory_Id(category.getId());
            List<Brand> brandList = new ArrayList<Brand>();

            for (Product product : products) {
                Brand brand = product.getBrand();
                if (!brandList.contains(brand)) {
                    brandList.add(brand);
                    System.out.println(brand.getName());
                }
            }
            return brandList;
        }
        return null;
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
