package com.yoakan.healtyapi.excercise.dto;

import com.yoakan.healtyapi.common.dto.Response;
import com.yoakan.healtyapi.common.utils.ListMultiLanguage;
import com.yoakan.healtyapi.common.utils.MultiLanguage;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcerciseMultiLanguageDto implements Response {
    private MultiLanguage name;
    private MultiLanguage description;
    private ListMultiLanguage stimulus;
    private MultiLanguage type;
    private ArrayList<String> urlVideos;
}
