package com.yoakan.healtyapi.excercise;

import com.mongodb.lang.NonNull;
import com.yoakan.healtyapi.excercise.dto.ExcerciseDto;
import com.yoakan.healtyapi.common.utils.ListMultiLanguage;
import com.yoakan.healtyapi.common.utils.MultiLanguage;
import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Excercise")
public class ExcerciseModel {

    @Transient
    public static final String SEQUENCE_NAME = "excercise_sequence";

    @Id
    @NonNull
    private Long id;
    private MultiLanguage name;
    private MultiLanguage description;
    private ListMultiLanguage stimulus;
    private MultiLanguage type;
    private List<String> urlVideos;

    public void setOtherLanguegeProperties(String language, ExcerciseDto dto){
        if (!StringUtils.isBlank(dto.getName())) {
            this.name.addLanguage(language, dto.getName());
        }
        if (!StringUtils.isBlank(dto.getDescription())) {
            this.description.addLanguage(language, dto.getDescription());
        }
        if (dto.getStimulus()!=null) {
            this.stimulus.addLanguage(language, dto.getStimulus());
        }
        if (!StringUtils.isBlank(dto.getType())) {
            this.type.addLanguage(language, dto.getType());
        }
    }

}
