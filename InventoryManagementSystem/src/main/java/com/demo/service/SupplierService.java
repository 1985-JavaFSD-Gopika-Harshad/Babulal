package com.demo.service;

import com.demo.dto.SupplierDTO;
import com.demo.model.Supplier;
import com.demo.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierDTO addSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setName(supplierDTO.getName());
        supplier.setContactInfo(supplierDTO.getContactInfo());
        return convertToDTO(supplierRepository.save(supplier));
    }

    public SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO) {
        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));
        supplier.setName(supplierDTO.getName());
        supplier.setContactInfo(supplierDTO.getContactInfo());
        return convertToDTO(supplierRepository.save(supplier));
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public SupplierDTO getSupplierById(Long id) {
        return convertToDTO(supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found")));
    }

    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private SupplierDTO convertToDTO(Supplier supplier) {
        SupplierDTO dto = new SupplierDTO();
        dto.setId(supplier.getId());
        dto.setName(supplier.getName());
        dto.setContactInfo(supplier.getContactInfo());
        return dto;
    }
}
