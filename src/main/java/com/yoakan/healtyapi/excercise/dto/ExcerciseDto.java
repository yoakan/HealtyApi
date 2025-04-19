package com.yoakan.healtyapi.excercise.dto;



import com.yoakan.healtyapi.common.dto.Response;
import com.yoakan.healtyapi.excercise.ExcerciseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExcerciseDto implements Response {

    private String name;
    private String description;
    private List<String> stimulus;
    private String type;
    private List<String> urlVideos;
    public ExcerciseDto(ExcerciseModel excerciseModel,String language){
        if(excerciseModel.getName()!=null)
            name = excerciseModel.getName().getValue(language);
        if(excerciseModel.getDescription()!=null){
            description = excerciseModel.getDescription().get(language);
        }
        if(excerciseModel.getStimulus()!=null)
            stimulus = excerciseModel.getStimulus().getValue(language);
        if(excerciseModel.getType()!=null)
            type= excerciseModel.getType().getValue(language);
        urlVideos = excerciseModel.getUrlVideos();

    }
}
