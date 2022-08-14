package com.project.weatherapi.service;

import com.project.weatherapi.model.entity.CityEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

@Service
@Scope("application")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityStoreService {
    HashMap<Integer, CityEntity> cityMap = new HashMap<>();

    public CityEntity storeCityWithKey(Integer key, CityEntity cityEntity) {
        Optional.ofNullable(cityMap.get(key)).ifPresent(e -> {
            throw new DuplicateKeyException("City with given key is already in the list!");
        });
        return cityMap.put(key, cityEntity);
    }

    public Collection<CityEntity> getAllMapValues(){
        return cityMap.values();
    }

}
