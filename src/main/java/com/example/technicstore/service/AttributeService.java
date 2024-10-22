package com.example.technicstore.service;

import com.example.technicstore.entity.Attribute;
import com.example.technicstore.repository.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;

    // Lấy tất cả thuộc tính
    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }

    // Lấy thuộc tính theo ID
    public Optional<Attribute> getAttributeById(Long id) {
        return attributeRepository.findById(id);
    }

    // Lấy thuộc tính theo tên gần đúng
    public List<Attribute> getAttributeByNameContaining(String name) {
        return attributeRepository.findAttributeByNameContainingIgnoreCase(name);
    }

    // Lấy thuộc tính theo tên chính xác
    public List<Attribute> getAttributeByName(String name) {
        return attributeRepository.findAttributesByName(name);
    }

    // Tạo mới thuộc tính
    public Attribute createAttribute(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    // Cập nhật thuộc tính
    public Attribute updateAttribute(Long id, Attribute updatedAttribute) {
        Optional<Attribute> attributeOptional = attributeRepository.findById(id);
        if (attributeOptional.isPresent()) {
            Attribute existingAttribute = attributeOptional.get();
            existingAttribute.setName(updatedAttribute.getName());
            existingAttribute.setParent(updatedAttribute.getParent())   ;
            return attributeRepository.save(existingAttribute);
        }
        return null;
    }

    // Xóa thuộc tính
    public void deleteAttribute(Long id) {
        attributeRepository.deleteById(id);
    }
}
