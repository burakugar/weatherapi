package com.project.weatherapi.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
@Data
@RequiredArgsConstructor
@JsonIgnoreProperties({"coord", "weather", "base", "visibility", "wind", "clouds", "dt", "sys", "timezone", "cod"})
public class CityWithIdResponse implements Serializable {
    private Integer id;
    private String name;

    @JsonDeserialize(using = BodyDeserializer.class)
    @JsonProperty("main")
    private HashMap<String, Object> main;

    private static class BodyDeserializer extends JsonDeserializer<Map<String, Object>> {

        @Override
        public Map<String, Object> deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
            JsonDeserializer<Object> deserializer = dc.findRootValueDeserializer(dc.constructType(Map.class));
            Map<String, Object> map = (Map<String, Object>) deserializer.deserialize(jp, dc);
            return map;
        }
    }
}
