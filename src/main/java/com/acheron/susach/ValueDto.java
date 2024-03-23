package com.acheron.susach;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValueDto {
    private Float dayPrice;
    private Float nightPrice;
}
