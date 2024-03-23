package com.acheron.susach;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ValueRepo extends MongoRepository<Value,Integer> {

    Optional<Value> findValueByUser(User user);
    List<Value> findValuesByUser(User user);
}
