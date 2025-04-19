package com.yoakan.healtyapi.food;



import com.mongodb.lang.NonNull;
import com.yoakan.healtyapi.common.dto.QuantifiedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Food")
public class FoodModel {

    @Transient
    public static final String SEQUENCE_NAME = "food_sequence";

    @Id
    @NonNull
    private Long id;
    private String language;
    @Indexed(unique=true)
    private String name;
    private String urlImage;
    private String description;
    private QuantifiedValue amount;
    private Map<String, QuantifiedValue> valueNutritional;
    private List<String> ingredients;
    private String maker;
    private String using;
    private String preservation;
}
