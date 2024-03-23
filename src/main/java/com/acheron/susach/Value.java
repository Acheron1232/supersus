package com.acheron.susach;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("value")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Value {
    @Id
    private Integer id;

    private Integer day;
    private Integer night;
    private User user;
    private LocalDateTime time;
}
