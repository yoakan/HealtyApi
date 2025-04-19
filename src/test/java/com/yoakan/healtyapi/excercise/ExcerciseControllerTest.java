package com.yoakan.healtyapi.excercise;

import com.yoakan.healtyapi.common.exceptions.NotFoundException;
import com.yoakan.healtyapi.excercise.dto.ExcerciseDto;
import com.yoakan.healtyapi.excercise.dto.ExcerciseMultiLanguageDto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;


import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExcerciseControllerTest {
    private ExcerciseController controller;
    @Mock
    private ExcerciseService excerciseService;

    @BeforeEach
    void setUp() {
        controller = new ExcerciseController(excerciseService);

    }

    @Test
    void getExcercises() {
        Assertions.assertNotNull(controller.getExcercises());
    }

    @Test
    void findExcercise() {
        when(excerciseService.findExcercise(anyLong())).thenReturn(new ExcerciseModel());
        Assertions.assertNotNull(controller.findExcercise("",1L));
    }
    @Test
    void findExcerciseCatch() {
        Assertions.assertNotNull(controller.findExcercise("",1L));
    }
    @Test
    void findExcerciseName() {
        when(excerciseService.findExcercise(anyString(),anyString())).thenReturn(new ArrayList<>());
        Assertions.assertNotNull(controller.findExcerciseName("test","test"));
    }


    @Test
    void addExcercise() {
        Assertions.assertNotNull(controller.addExcercise(new ExcerciseMultiLanguageDto()));
    }
    @Test
    void deleteExcercise() {
        Assertions.assertNotNull(controller.deleteExcercise(0L));
    }

    @Test
    void addLanguegeExcercise() {
        Assertions.assertNotNull(controller.addLanguegeExcercise(new ExcerciseDto(),"test",0L));
    }
    @Test
    void addLanguegeExcerciseThrow() {
        doThrow(new NotFoundException()).when(excerciseService).modifyLanguage(anyLong(),anyString(),any());
        Assertions.assertNotNull(controller.addLanguegeExcercise(new ExcerciseDto(),"test",0L));
    }
}