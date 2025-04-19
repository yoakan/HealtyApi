package com.yoakan.healtyapi.common.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import static com.yoakan.healtyapi.common.constants.Languages.DASH;

public class MapLanguage<V> extends HashMap<String, V> {
    public V getValue(String language){
        language = modifyLanguge(language);
        return this.get(language);

    }
    public void addLanguage(String language, V object){
        language = modifyLanguge(language);
        this.put(language,object);
    }
    private String modifyLanguge(String language){
        if((!language.contains(DASH))){
            language = language.concat(DASH).concat(language.toUpperCase());
        }
        return language;
    }


}
