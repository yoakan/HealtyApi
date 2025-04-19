package com.yoakan.healtyapi.excercise.dto;

import com.yoakan.healtyapi.common.utils.ListMultiLanguage;
import com.yoakan.healtyapi.common.utils.MultiLanguage;
import com.yoakan.healtyapi.excercise.ExcerciseModel;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;


@ExtendWith(MockitoExtension.class)
class ExcerciseDtoTest {
    private ExcerciseDto excerciseDto;


    @Test
     void ExcerciseDtoContructorTest(){
        excerciseDto = new ExcerciseDto(new ExcerciseModel(),"ES");
        Assertions.assertNotNull(excerciseDto);
    }
    @Test

     void ExcerciseDtoContructorIfTest(){

        excerciseDto = new ExcerciseDto(new ExcerciseModel(
                0L,new MultiLanguage(),new MultiLanguage(),new ListMultiLanguage(),new MultiLanguage(),new ArrayList<>()
                )
                ,"ES");
        Assertions.assertNotNull(excerciseDto);
    }
}