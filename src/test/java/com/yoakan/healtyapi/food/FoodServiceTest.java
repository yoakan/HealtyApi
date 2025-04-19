package com.yoakan.healtyapi.food;

import com.yoakan.healtyapi.common.exceptions.NotFoundException;
import com.yoakan.healtyapi.common.sequence.SequenceService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;


import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FoodServiceTest {
    private FoodService service;
    @Mock
    private FoodRepository foodRepository;
    @Mock
    private SequenceService sequenceService;

    @BeforeEach
    void setUp() {
        service = new FoodService(foodRepository,sequenceService);
    }
    @Test
    void create() {
        service.create(new FoodDto());
        verify(sequenceService).getNextValue(anyString());
    }

    @Test
    void getFood() {
        when(foodRepository.findFoodModelsById(anyLong())).thenReturn(Optional.of(new FoodModel()));
       Assertions.assertNotNull(service.findFood(0L));
    }
    @Test
    void getFoodCatch() {

        Assertions.assertThrows(NotFoundException.class,()->service.findFood(0L));

    }

    @Test
    void getAllFood() {
        Assertions.assertNotNull(service.getAllFood());
    }

    @Test
    void findFoodName() {
        Assertions.assertNotNull(service.findFood("NAME"));
    }

    @Test
    void deleteFood() {
        service.deleteFood(0L);
        verify(foodRepository).deleteById(anyLong());

    }


}