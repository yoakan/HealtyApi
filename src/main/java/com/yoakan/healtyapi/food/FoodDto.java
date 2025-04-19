package com.yoakan.healtyapi.food;

import com.yoakan.healtyapi.common.dto.QuantifiedValue;
import com.yoakan.healtyapi.common.dto.Response;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodDto implements Response {
    private String name;
    private String language;
    private String urlImage;
    private String description;
    private QuantifiedValue amount;
    private Map<String, QuantifiedValue> valueNutritionals;
    private List<String> ingredients;
    private String maker;
    private String using;
    private String preservation;
}
