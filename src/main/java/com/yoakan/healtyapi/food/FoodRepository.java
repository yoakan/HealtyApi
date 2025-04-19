package com.yoakan.healtyapi.food;


import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;
import java.util.Optional;

public interface FoodRepository extends MongoRepository<FoodModel, Long> {
    Optional<FoodModel> findFoodModelsById(Long id);
    List<FoodModel> findFoodModelsByNameContaining(String name);
}
