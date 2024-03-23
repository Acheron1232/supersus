package com.acheron.susach;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EntityRepo extends MongoRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}
