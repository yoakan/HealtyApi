package com.yoakan.healtyapi.excercise;

import com.yoakan.healtyapi.common.exceptions.NotFoundException;
import com.yoakan.healtyapi.common.sequence.SequenceService;
import com.yoakan.healtyapi.excercise.dto.ExcerciseDto;
import com.yoakan.healtyapi.excercise.dto.ExcerciseMultiLanguageDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ExcerciseServiceTest {

    private ExcerciseService service;
    @Mock
    private ExcerciseRepository excerciseRepository;
    @Mock
    private SequenceService sequenceService;

    @BeforeEach
    void setUp() {
        service = new ExcerciseService(excerciseRepository,sequenceService);
    }

    @Test
    void getAllItems() {
        Assertions.assertNotNull(service.getAllItems());
    }

    @Test
    void findExcercise() {
        when(excerciseRepository.findById(anyLong())).thenReturn(Optional.of(new ExcerciseModel()));
        Assertions.assertNotNull(service.findExcercise(1L));
    }
    @Test
    void findExcerciseThrow() {

        Assertions.assertThrows(NotFoundException.class,()->service.findExcercise(1L));
    }

    @Test
    void findExcerciseName() {
        Assertions.assertNotNull(service.findExcercise("test","test"));
    }

    @Test
    void create() {
        ExcerciseMultiLanguageDto excercise =new ExcerciseMultiLanguageDto();
        service.create(excercise);
        verify(excerciseRepository).save(any());
    }

    @Test
    void modifyLanguage() {
        Optional<ExcerciseModel> excercise = Optional.of(new ExcerciseModel());
        when(excerciseRepository.findById(anyLong())).thenReturn(excercise);
        service.modifyLanguage(0L,"es-ES",new ExcerciseDto());

        verify(excerciseRepository).save(any());
    }
    @Test
    void mopifyLanguageeThrow() {

        Assertions.assertThrows(NotFoundException.class,()->service.modifyLanguage(0L,"es-ES",new ExcerciseDto()));
    }
    @Test
    void deleteExcercise() {
        service.deleteExcercise(0L);
        verify(excerciseRepository).deleteById(anyLong());
    }
}