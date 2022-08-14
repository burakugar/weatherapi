package com.project.weatherapi.controller;

import com.project.weatherapi.model.dto.CityDto;
import com.project.weatherapi.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/city")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/{id}")
    public CityDto getById(@PathVariable Integer id) {
        return cityService.getCityById(id);
    }

    @GetMapping()
    public List<CityDto> getAllCities() {
        return cityService.getAllCities();
    }

    @PostMapping("/request")
    public CityDto requestByName(@RequestParam String name, @RequestParam String appId) {
        return cityService.requestWeatherByName(name, appId);
    }
}
