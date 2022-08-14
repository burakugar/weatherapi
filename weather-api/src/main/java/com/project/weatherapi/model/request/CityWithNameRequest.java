package com.project.weatherapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Size;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CityWithNameRequest {
    @Size(min = 1, max = 255, message = "Name can not be larger than 255 or less than 1 character!")
    String name;
}

