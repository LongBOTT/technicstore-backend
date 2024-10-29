package com.example.technicstore.repository;
import com.example.technicstore.entity.Variant_Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface Variant_AttributeRepository extends JpaRepository<Variant_Attribute, Long>{
    // Tìm kiếm theo ID biến thể
    List<Variant_Attribute> findVariant_AttributesByVariant_IdAndAndAttribute_IdAndAndValue(long variantId, long attributeId, String attributeValue);
    List<Variant_Attribute> findVariant_AttributeByVariantId(long variantId);

}
