package com.example.technicstore.service;

import com.example.technicstore.DTO.Request.ProductCreationRequest;
import com.example.technicstore.DTO.Response.ProductResponese;
import com.example.technicstore.DTO.Response.VariantAttributeResponse;
import com.example.technicstore.DTO.Response.VariantResponse;
import com.example.technicstore.Mapper.ProductMapper;
import com.example.technicstore.Mapper.VariantAttributeMapper;
import com.example.technicstore.Mapper.VariantMapper;
import com.example.technicstore.entity.*;
import com.example.technicstore.repository.BrandRepository;
import com.example.technicstore.repository.CategoryRepository;
import com.example.technicstore.repository.ProductRepository;
import com.example.technicstore.repository.WarrantyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private VariantService variantService;
    @Autowired
    private AttributeService attributeService;
    @Autowired
    private Variant_AttributeService variant_AttributeService;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private WarrantyRepository warrantyRepository;

    // Lấy tất cả sản phẩm
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Lấy sản phẩm theo ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }


    // Tìm các sản phẩm gần đúng theo tên
    public List<Product> getProductsByNameContaining(String name) {
        return productRepository.findProductByNameContainingIgnoreCase(name);
    }

    // Tìm các sản phẩm gần đúng theo tên
    public List<Product> getProductsByBrand_Id(long id) {
        return productRepository.findProductsByBrand_Id(id);
    }


    public List<ProductResponese> getProductsAndVariants() {
        List<Product> products = productRepository.findProductsByStatus("active");
        List<ProductResponese> productDTOS = new ArrayList<>();

//        List<VariantAttributeDTO> variantAttributeDTOS = new ArrayList<>();
        for (Product product : products) {
            List<VariantResponse> variantDTOS = new ArrayList<>();
            ProductResponese productDTO = ProductMapper.toDTO(product);
            List<Variant> variants = variantService.getVariantsByProductId(product.getId());
            for (Variant variant : variants) {
                VariantResponse variantDTO = VariantMapper.toDTO(variant);
                variantDTOS.add(variantDTO);
            }
            productDTO.setVariants(variantDTOS);
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

    public ProductResponese getProductsAndVariantsAndAttributes(Long productId) {
        Product product = productRepository.findProductById(productId);
        ProductResponese productDTO = ProductMapper.toDTO(product);
        List<Variant> variants = variantService.getVariantsByProductId(product.getId());
        List<VariantResponse> variantDTOS = new ArrayList<>();
        for (Variant variant : variants) {
            VariantResponse variantDTO = VariantMapper.toDTO(variant);
            variantDTOS.add(variantDTO);
            List<Variant_Attribute> variant_attributes = variant_AttributeService.findVariant_AttributeByVariantId(variant.getId());
            List<VariantAttributeResponse> variantAttributeDTOs = new ArrayList<>();
            for (Variant_Attribute variant_attribute : variant_attributes) {
                VariantAttributeResponse variantAttributeDTO = VariantAttributeMapper.toDTO(variant_attribute);
                variantAttributeDTOs.add(variantAttributeDTO);
            }
            variantDTO.setAttributes(variantAttributeDTOs);
        }
        productDTO.setVariants(variantDTOS);
        return productDTO;
    }


    public List<ProductResponese> searchProductWithVariantByName(String name) {
        List<Product> products = productRepository.findProductByNameContainingIgnoreCaseAndStatus(name, "active");
        List<com.example.technicstore.DTO.Response.ProductResponese> productDTOS = new ArrayList<>();

        for (Product product : products) {
            List<VariantResponse> variantDTOS = new ArrayList<>();
            com.example.technicstore.DTO.Response.ProductResponese productDTO = ProductMapper.toDTO(product);
            List<Variant> variants = variantService.getVariantsByProductId(product.getId());
            for (Variant variant : variants) {
                VariantResponse variantDTO = VariantMapper.toDTO(variant);
                variantDTOS.add(variantDTO);
            }
            productDTO.setVariants(variantDTOS);
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

    public List<ProductResponese> searchProductWithVariantByCategory(Long categoryID) {
        List<Product> products = productRepository.findProductsByCategory_IdAndStatus(categoryID,"active");
        List<com.example.technicstore.DTO.Response.ProductResponese> productDTOS = new ArrayList<>();

        for (Product product : products) {
            List<VariantResponse> variantDTOS = new ArrayList<>();
            com.example.technicstore.DTO.Response.ProductResponese productDTO = ProductMapper.toDTO(product);
            List<Variant> variants = variantService.getVariantsByProductId(product.getId());
            for (Variant variant : variants) {
                VariantResponse variantDTO = VariantMapper.toDTO(variant);
                variantDTOS.add(variantDTO);
            }
            productDTO.setVariants(variantDTOS);
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }
    public List<ProductResponese> searchProductWithVariantByBrand(Long brandID) {
        List<Product> products = productRepository.findProductsByBrand_IdAndStatus(brandID,"active");
        List<com.example.technicstore.DTO.Response.ProductResponese> productDTOS = new ArrayList<>();

        for (Product product : products) {
            List<VariantResponse> variantDTOS = new ArrayList<>();
            com.example.technicstore.DTO.Response.ProductResponese productDTO = ProductMapper.toDTO(product);
            List<Variant> variants = variantService.getVariantsByProductId(product.getId());
            for (Variant variant : variants) {
                VariantResponse variantDTO = VariantMapper.toDTO(variant);
                variantDTOS.add(variantDTO);
            }
            productDTO.setVariants(variantDTOS);
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

    public List<Product> getProductByCategory_Id(long id) {
        return productRepository.findProductsByCategory_Id(id);
    }

    public List<Product> getProductInVariants(List<Variant> variants) {
        Set<Long> productIds = new HashSet<>();  // Sử dụng Set để theo dõi các ID sản phẩm đã được thêm
        List<Product> products = new ArrayList<>();  // Danh sách các sản phẩm kết quả

        for (Variant variant : variants) {
            Product product = variant.getProducts();  // Lấy sản phẩm từ variant

            if (product != null && !productIds.contains(product.getId())) {  // Kiểm tra sản phẩm có tồn tại trong Set không
                products.add(product);  // Thêm sản phẩm vào danh sách
                productIds.add(product.getId());  // Thêm ID sản phẩm vào Set để theo dõi
            }
        }

        return products;  // Trả về danh sách các sản phẩm duy nhất
    }

    // cập nhật trạng thái theo id
    public Product updateStatus(Long id, String status) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        Product existingProduct = productOptional.get();
        existingProduct.setStatus(status);
        return productRepository.save(existingProduct);
    }
    // Tìm sản phẩm theo tên chính xác
    public Optional<Product> getProductByName(String name) {
        return productRepository.findProductByName(name);
    }

    // Tạo mới một sản phẩm
    public Product createProduct(ProductCreationRequest request) {
        if (productRepository.findProductByName(request.getName()).isPresent()) {
            throw new RuntimeException("Product is already exist");
        }
        Product product = ProductMapper.toEntity(request);
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        Brand brand = brandRepository.findById(request.getBrandId()).orElseThrow(() -> new RuntimeException("Brand not found"));
        Warranty warranty = warrantyRepository.findById(request.getWarrantyId()).orElseThrow(() -> new RuntimeException("Warranty not found"));
        product.setCategory(category);
        product.setBrand(brand);
        product.setWarranty(warranty);
        return productRepository.save(product);
    }


    // Cập nhật thông tin sản phẩm
    public Product updateProduct(Long id, ProductCreationRequest updatedProduct) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found");
        }

        Product existingProduct = productOptional.get();


        Category category = categoryRepository.findById(updatedProduct.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Brand brand = brandRepository.findById(updatedProduct.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        Warranty warranty = warrantyRepository.findById(updatedProduct.getWarrantyId())
                .orElseThrow(() -> new RuntimeException("Warranty not found"));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setImage(updatedProduct.getImage());
        existingProduct.setUnit(updatedProduct.getUnit());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setWeight(updatedProduct.getWeight());
        existingProduct.setCategory(category);
        existingProduct.setBrand(brand);
        existingProduct.setWarranty(warranty);

        return productRepository.save(existingProduct);
    }


    // Xóa sản phẩm
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
