package com.yoakan.healtyapi.excercise;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ExcerciseRepository extends MongoRepository<ExcerciseModel, Long> {
    Optional<ExcerciseModel> findById(Long id);
    List<ExcerciseModel> findExcerciseModelByNameContaining(String key,String name);
    @Query("{'name.?0': { $regex: ?1, $options: 'i' } }")
    List<ExcerciseModel> findByName(String key,String name);
}
