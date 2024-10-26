package com.example.technicstore.service;

import com.example.technicstore.entity.Variant_Attribute;
import com.example.technicstore.repository.SupplierRepository;
import com.example.technicstore.repository.Variant_AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class Variant_AttributeService {
    @Autowired
    private Variant_AttributeRepository variant_AttributeRepository;
    // Tìm kiếm theo ID biến thể
    public List<Variant_Attribute> findVariant_AttributeByVariantId(long variantId) {
        return variant_AttributeRepository.findVariant_AttributeByVariantId(variantId);
    }

    // Tạo mới thuộc tính biến thể
    public Variant_Attribute createVariant_Attribute(Variant_Attribute variant_Attribute) {
        return variant_AttributeRepository.save(variant_Attribute);
    }

    // Cập nhật thuộc tính biến thể
    public Variant_Attribute updateVariant_Attribute(Long id, Variant_Attribute variant_Attribute) {
        Optional<Variant_Attribute> variant_AttributeOptional = variant_AttributeRepository.findById(id);
        if (!variant_AttributeOptional.isPresent()) {
            return null;
        }
        variant_Attribute.setId(id);
        return variant_AttributeRepository.save(variant_Attribute);
    }

    // Xóa thuộc tính biến thể
    public boolean deleteVariant_Attribute(Long id) {
        Optional<Variant_Attribute> variant_AttributeOptional = variant_AttributeRepository.findById(id);
        if (!variant_AttributeOptional.isPresent()) {
            return false;
        }
        variant_AttributeRepository.deleteById(id);
        return true;
    }

}
