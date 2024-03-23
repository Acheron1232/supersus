package com.acheron.susach;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("entity")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    private Integer id;

    private String email;

    public User(String email) {
        this.email = email;
    }




}
