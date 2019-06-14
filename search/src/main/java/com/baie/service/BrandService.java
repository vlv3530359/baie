package com.baie.service;

import com.baie.repository.BrandRepository;
import com.baie.entity.Brand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class BrandService {
    @Autowired
    BrandRepository brandRepository;

    public boolean addBrand(Brand brand) {
        log.info("Add brand: " + brand);
        try {
            save(brand);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteBrand(String id) {
        log.info("Delete brand: " + id);
        try {
            brandRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("Delete brand with error: ", e);
            return false;
        }
    }

    public boolean deleteAll() {
        log.info("Delete all brands.");
        try {
            brandRepository.deleteAll();
            return true;
        } catch (Exception e) {
            log.error("Delete all brands with error: ", e);
            return false;
        }
    }

    public boolean update(Brand brand) {
        log.info("Update brand: " + brand);
        Optional<Brand> originalBrand = brandRepository.findById(brand.getId());
        return originalBrand.map(i->save(brand)).orElse(false);
    }

    private boolean save(Brand brand) {
        try {
            brandRepository.save(brand);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
