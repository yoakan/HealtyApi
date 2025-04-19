package com.yoakan.healtyapi.common.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class MapLanguageTest {
    MapLanguage<String> mapLanguage = new MapLanguage<>();
    @BeforeEach
    void setUp() {
        mapLanguage.put("test-test","test");

    }



    @Test
    void getValue() {
        Assertions.assertNull(mapLanguage.getValue("testtt"));
    }



    @Test
    void addLanguage() {


        Assertions.assertDoesNotThrow(()->{mapLanguage.addLanguage("aaa","testtt");});

    }
}