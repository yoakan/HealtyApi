package com.yoakan.healtyapi.common.sequence;



import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@AllArgsConstructor
public class SequenceService {

    private final MongoOperations mongo;

    public Long getNextValue(String seqName) {
        DataBaseSequence counter = mongo.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DataBaseSequence.class);
        return !Objects.isNull(counter) ? counter.getSeq() : 1;
    }
}
