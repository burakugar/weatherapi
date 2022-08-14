package com.project.weatherapi.service;

import com.project.weatherapi.client.CityClient;
import com.project.weatherapi.exception.CityNotFoundWithIdException;
import com.project.weatherapi.model.converter.CityConverter;
import com.project.weatherapi.model.dto.CityDto;
import com.project.weatherapi.model.entity.CityEntity;
import com.project.weatherapi.model.request.CityWithNameResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CityService {
    private final CityClient cityClient;
    private final CityStoreService cityStoreService;

    public CityDto getCityById(Integer id) {
        CityEntity cityEntity = Optional.ofNullable(cityStoreService.cityMap.get(id))
                .orElseThrow(CityNotFoundWithIdException::new);
        return CityConverter
                .toCityDto(cityEntity);
    }

    public List<CityDto> getAllCities() {
        List<CityDto> cityDtos = cityStoreService
                .getAllMapValues()
                .stream()
                .map(CityConverter::toCityDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), result -> {
                    if (result.isEmpty()) throw new RuntimeException("There is no city in List!!");
                    return result;
                }));
        return cityDtos;
    }

    public CityDto requestWeatherByName(String name, String appId) {
        CityWithNameResponse cityWithNameResponse = cityClient.getByName(name, appId);
        CityEntity cityEntity = CityConverter.responseWithNameToCityEntity(cityWithNameResponse);
        cityStoreService.storeCityWithKey(cityEntity.getId(), cityEntity);
        return CityConverter
                .toCityDto(cityEntity);
    }

}
