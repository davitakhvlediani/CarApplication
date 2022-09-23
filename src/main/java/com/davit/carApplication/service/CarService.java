package com.davit.carApplication.service;

import com.davit.carApplication.model.domain.Car;
import com.davit.carApplication.repostories.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService extends AbstractService<Car, CarRepository> {


    public CarService(CarRepository repository) {
        super(repository);
    }
}
