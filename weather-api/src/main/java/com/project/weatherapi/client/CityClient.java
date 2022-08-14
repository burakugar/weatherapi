package com.project.weatherapi.client;

import com.project.weatherapi.model.request.CityWithIdResponse;
import com.project.weatherapi.model.request.CityWithNameResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Validated
@FeignClient(name = "city-service", url = "https://api.openweathermap.org/data/2.5/weather", decode404 = true)
public interface CityClient {

    @GetMapping
    @Valid
    CityWithNameResponse getByName(@RequestParam String q, @RequestParam String appid);
}
