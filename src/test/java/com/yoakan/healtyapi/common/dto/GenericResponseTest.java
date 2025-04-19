package com.yoakan.healtyapi.common.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericResponseTest {

    @Test
    void success() {
        Assertions.assertNotNull(GenericResponse.success());
    }

    @Test
    void internalError() {
        Assertions.assertNotNull(GenericResponse.internalError());
    }

    @Test
    void notFoundError() {
        Assertions.assertNotNull(GenericResponse.notFoundError());
    }
    @Test
    void genenericConstructor(){
        Assertions.assertNotNull(new GenericResponse("test"));
    }
}