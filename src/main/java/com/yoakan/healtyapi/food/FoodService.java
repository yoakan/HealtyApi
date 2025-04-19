package com.yoakan.healtyapi.food;

import com.yoakan.healtyapi.common.exceptions.NotFoundException;
import com.yoakan.healtyapi.common.sequence.SequenceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FoodService {

    private final FoodRepository repository;

    private final SequenceService sequenceService;
    public void create(FoodDto dto){
        repository.save(FoodModel.builder()
                        .id(sequenceService.getNextValue(FoodModel.SEQUENCE_NAME))
                    .name(dto.getName())
                    .language(dto.getLanguage())
                    .amount(dto.getAmount())
                    .maker(dto.getMaker())
                    .urlImage(dto.getUrlImage())
                    .description(dto.getDescription())
                    .valueNutritional(dto.getValueNutritionals())
                    .using(dto.getUsing())
                    .preservation(dto.getPreservation())
                    .ingredients(dto.getIngredients())
                .build());
    }










    public List<FoodModel> getAllFood() {
        return repository.findAll();
    }
    public FoodModel findFood(Long id) throws NotFoundException {
        Optional<FoodModel> optional = repository.findFoodModelsById(id);
        if (optional.isPresent())
            return optional.get();
        throw new NotFoundException();
    }
    public void deleteFood(Long id) throws NullPointerException{

        repository.deleteById(id);
    }
    public List<FoodModel> findFood(String name) throws NullPointerException{

        return repository.findFoodModelsByNameContaining(name);
    }
}
