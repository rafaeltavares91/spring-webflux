package com.example.springwebflux.repository;

import com.example.springwebflux.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}
