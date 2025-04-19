package com.yoakan.healtyapi.food;

import com.yoakan.healtyapi.common.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FoodsControllerTest {
    private FoodsController controller;
    @Mock
    private FoodService service;

    @BeforeEach
    void setUp() {
        controller = new FoodsController(service);
    }

    @Test
    void getFoods() {
        Assertions.assertNotNull(controller.getFoods());
    }

    @Test
    void findFood() {
        Assertions.assertNotNull(controller.findFood(0L));
    }
    @Test
    void findFoodCatch() {
        when(service.findFood(anyLong())).thenThrow(NotFoundException.class);
        Assertions.assertNotNull(controller.findFood(0L));
    }

    @Test
    void findFoodName() {
        Assertions.assertNotNull(controller.findFoodName("test"));
    }

    @Test
    void addFood() {
        controller.addFood(new FoodDto());
        verify(service).create(any());
    }
    @Test
    void deleteFood() {
        controller.deleteFood(0L);
        verify(service).deleteFood(anyLong());
    }
}