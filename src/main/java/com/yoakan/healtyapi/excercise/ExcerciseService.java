package com.yoakan.healtyapi.excercise;

import com.yoakan.healtyapi.common.exceptions.NotFoundException;
import com.yoakan.healtyapi.common.sequence.SequenceService;
import com.yoakan.healtyapi.excercise.dto.ExcerciseDto;
import com.yoakan.healtyapi.excercise.dto.ExcerciseMultiLanguageDto;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExcerciseService {

    private final ExcerciseRepository repository;

    private final SequenceService sequenceService;
    public List<ExcerciseModel> getAllItems() {
        return repository.findAll();
    }
    public ExcerciseModel findExcercise(Long id) throws NotFoundException {
        Optional<ExcerciseModel> excercise =repository.findById(id);
        if(excercise.isPresent()){
            return excercise.get();
        }else{
            throw new NotFoundException();
        }

    }
    public List<ExcerciseModel> findExcercise(String language,String name) throws NullPointerException{

        return repository.findByName(language,name);
    }
    public void create(ExcerciseMultiLanguageDto dto){

        repository.save(ExcerciseModel.builder()
                        .id(sequenceService.getNextValue(ExcerciseModel.SEQUENCE_NAME))
                        .name(dto.getName())
                        .description(dto.getDescription())
                        .stimulus(dto.getStimulus())
                        .type(dto.getType())
                        .urlVideos(dto.getUrlVideos())
                .build());
    }
    public void modifyLanguage(Long id, String language, ExcerciseDto excerciseDto)throws  NotFoundException{
        Optional<ExcerciseModel> optionalExcerciseModel= repository.findById(id);
        ExcerciseModel excerciseModel ;
        if(optionalExcerciseModel.isPresent()){
            excerciseModel = optionalExcerciseModel.get();
            excerciseModel.setOtherLanguegeProperties(language,excerciseDto);
            repository.save(excerciseModel);
        }else {
            throw new NotFoundException();
        }

    }
    public void deleteExcercise(Long id) throws NullPointerException{

        repository.deleteById(id);
    }
}
