package com.yoakan.healtyapi.common.sequence;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "database_sequences")
@Value
public class DataBaseSequence {
    @Id
    private String id;

    private long seq;
}
