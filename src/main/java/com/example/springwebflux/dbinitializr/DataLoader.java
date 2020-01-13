package com.example.springwebflux.dbinitializr;

import com.example.springwebflux.domain.Category;
import com.example.springwebflux.domain.Vendor;
import com.example.springwebflux.repository.CategoryRepository;
import com.example.springwebflux.repository.VendorRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    @Override
    public void run(String... args) {
        loadData();
    }

    private void loadData() {
        categoryRepository.save(Category.builder().description("Fruits").build());
        categoryRepository.save(Category.builder().description("Nuts").build());
        categoryRepository.save(Category.builder().description("Breads").build());
        categoryRepository.save(Category.builder().description("Eggs").build());

        vendorRepository.save(Vendor.builder().firstName("Joe").lastName("Buck").build());
        vendorRepository.save(Vendor.builder().firstName("Michael").lastName("Weston").build());
        vendorRepository.save(Vendor.builder().firstName("Jessie").lastName("Waters").build());
        vendorRepository.save(Vendor.builder().firstName("Jimmy").lastName("Buffet").build());
    }

}
