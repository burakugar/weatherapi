package com.project.weatherapi.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"coord","weather","base","visibility","wind","clouds","dt","sys","timezone","cod"})
public class CityDto implements Serializable {
    private Integer id;
    private String name;
    private Double highest;
    private Double lowest;
}
