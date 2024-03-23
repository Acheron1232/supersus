package com.acheron.susach;

import org.springframework.stereotype.Component;

@Component
public class ValueMapper {
    @org.springframework.beans.factory.annotation.Value("${day}")
    private Float actualDayPrice;
    @org.springframework.beans.factory.annotation.Value("${night}")
    private Float actualNightPrice;

    public ValueDto convert(Value value){
        return new ValueDto(value.getDay()*actualDayPrice, actualNightPrice* value.getNight());
    }
}
