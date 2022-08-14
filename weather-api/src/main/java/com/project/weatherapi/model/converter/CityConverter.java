package com.project.weatherapi.model.converter;

import com.project.weatherapi.model.dto.CityDto;
import com.project.weatherapi.model.entity.CityEntity;
import com.project.weatherapi.model.request.CityWithNameResponse;

import java.util.Map;


public final class CityConverter {

    private CityConverter() {
        throw new IllegalStateException("Converter Class");
    }

    public static CityEntity responseWithNameToCityEntity(CityWithNameResponse cityWithNameResponse) {
        Map<String, Object> map = cityWithNameResponse.getMain();
        return CityEntity.builder()
                .id(cityWithNameResponse.getId())
                .name(cityWithNameResponse.getName())
                .highest((Double) map.get("temp_max"))
                .lowest((Double) map.get("temp_min"))
                .build();
    }

    public static CityDto toCityDto(CityEntity cityEntity) {
        return CityDto.builder()
                .id(cityEntity.getId())
                .name(cityEntity.getName())
                .lowest(cityEntity.getLowest())
                .highest(cityEntity.getHighest())
                .build();
    }
}
