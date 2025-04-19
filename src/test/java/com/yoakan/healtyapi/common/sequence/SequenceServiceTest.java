package com.yoakan.healtyapi.common.sequence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SequenceServiceTest {
    private SequenceService service;
    private MockedStatic<Criteria> criteriaMockedStatic;
    private MockedStatic<Query> queryMockedStatic;
    @Mock
    private MongoOperations mongoOperations;
    @BeforeEach
    void setUp() {
        service= new SequenceService(mongoOperations);
        criteriaMockedStatic = Mockito.mockStatic(Criteria.class);
        queryMockedStatic = Mockito.mockStatic(Query.class);
    }
    @AfterEach
    void tearDown() {
        criteriaMockedStatic.close();
        queryMockedStatic.close();
    }

    @Test
    void getNextValue() {
        Criteria criteria = Mockito.mock(Criteria.class);
        when(criteria.is(anyString())).thenReturn(criteria);
        when(Criteria.where(anyString())).thenReturn(criteria);

        Assertions.assertNotEquals(service.getNextValue("ej"),0);
    }


}