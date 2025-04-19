package com.yoakan.healtyapi.excercise;

import com.yoakan.healtyapi.common.utils.ListMultiLanguage;
import com.yoakan.healtyapi.common.utils.MultiLanguage;
import com.yoakan.healtyapi.excercise.dto.ExcerciseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;


@ExtendWith(MockitoExtension.class)
class ExcerciseModelTest {

    private ExcerciseModel excerciseModel;
    @BeforeEach
    void setUp() {
        excerciseModel = new ExcerciseModel(0L,new MultiLanguage(),new MultiLanguage(),new ListMultiLanguage(),new MultiLanguage(),new ArrayList<>());
    }
    @Test
     void setOtherLanguegePropertiesTest(){
        excerciseModel.setOtherLanguegeProperties("ej",new ExcerciseDto());
        Assertions.assertNotNull(excerciseModel.getName());
    }
    @Test
     void setOtherLanguegePropertiesIfTest(){
        excerciseModel.setOtherLanguegeProperties("ej",new ExcerciseDto(
                "test","test",new ArrayList<>(),"test",new ArrayList<>()
        ));
        Assertions.assertNotNull(excerciseModel.getName());
    }
}