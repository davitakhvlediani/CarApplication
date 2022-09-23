package com.davit.carApplication.model.mapper;

import com.davit.carApplication.model.domain.Car;
import com.davit.carApplication.model.dto.CarDTO;

public class CarMapper {

    public static CarDTO mapCarToDto(Car car){
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setName(car.getBrand());
        return carDTO;
    }
}
