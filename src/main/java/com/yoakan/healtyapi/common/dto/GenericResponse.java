package com.yoakan.healtyapi.common.dto;

import com.yoakan.healtyapi.common.constants.Constants;
import lombok.Value;

@Value
public class GenericResponse implements Response{
    private String message;
    public static GenericResponse success(){
        return new GenericResponse(Constants.DEFAULT_MESSAGE_SUCCESS);
    }
    public static GenericResponse internalError(){
        return new GenericResponse(Constants.DEFAULT_MESSAGE_ERROR_INTERAL);
    }
    public static GenericResponse notFoundError(){
        return new GenericResponse(Constants.NOT_FOUND_ERROR);
    }
    public GenericResponse(String message){
        this.message= message;
    }
}
