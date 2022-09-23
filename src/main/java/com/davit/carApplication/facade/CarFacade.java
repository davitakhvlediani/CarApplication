package com.davit.carApplication.facade;

import com.davit.carApplication.model.domain.Car;
import com.davit.carApplication.model.dto.CarDTO;
import com.davit.carApplication.model.enums.CarStatus;
import com.davit.carApplication.model.mapper.CarMapper;
import com.davit.carApplication.model.param.CarCreateParam;
import com.davit.carApplication.service.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarFacade {

    private final CarService carService;

    public CarFacade(CarService carService) {
        this.carService = carService;
    }

    public Page<CarDTO> getAllCar(Pageable pageable){
        Page<Car> all = carService.getAll(pageable);
        return   all.map(CarMapper::mapCarToDto);
    }
    public CarDTO getCarById(Long id){
        Car car = carService.get(id);
        return CarMapper.mapCarToDto(car);
    }
    public CarDTO saveCar(CarCreateParam param){
        Car car = new Car();
        car.setBrand(param.getCarName());
        car.setCarStatus(CarStatus.ACTIVE);
        Car savedCar = carService.create(car);
        return CarMapper.mapCarToDto(savedCar);
    }
}
