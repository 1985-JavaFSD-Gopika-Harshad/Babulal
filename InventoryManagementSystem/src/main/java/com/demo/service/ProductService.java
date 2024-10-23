package com.demo.service;

import com.demo.dto.ProductDTO;
import com.demo.model.Product;
import com.demo.model.Category; // Assuming you have a Category model
import com.demo.model.Supplier; // Assuming you have a Supplier model
import com.demo.repository.ProductRepository;
import com.demo.repository.CategoryRepository; // Assuming you have a CategoryRepository
import com.demo.repository.SupplierRepository; // Assuming you have a SupplierRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository; // Inject CategoryRepository

    @Autowired
    private SupplierRepository supplierRepository; // Inject SupplierRepository

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        
        // Set category and supplier
        if (productDTO.getCategoryId() != null) {
            Category category = categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            product.setCategory(category);
        }
        
        if (productDTO.getSupplierId() != null) {
            Supplier supplier = supplierRepository.findById(productDTO.getSupplierId())
                    .orElseThrow(() -> new RuntimeException("Supplier not found"));
            product.setSupplier(supplier);
        }

        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());

        // Update category and supplier
        if (productDTO.getCategoryId() != null) {
            Category category = categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            product.setCategory(category);
        }
        
        if (productDTO.getSupplierId() != null) {
            Supplier supplier = supplierRepository.findById(productDTO.getSupplierId())
                    .orElseThrow(() -> new RuntimeException("Supplier not found"));
            product.setSupplier(supplier);
        }

        return convertToDTO(productRepository.save(product));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public ProductDTO getProductById(Long id) {
        return convertToDTO(productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found")));
    }

    public List<ProductDTO> getLowStockProducts(int threshold) {
        return productRepository.findByQuantityLessThan(threshold).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        
        // Set category and supplier IDs if necessary
        if (product.getCategory() != null) {
            dto.setCategoryId(product.getCategory().getId());
        }
        
        if (product.getSupplier() != null) {
            dto.setSupplierId(product.getSupplier().getId());
        }
        
        return dto;
    }
}
