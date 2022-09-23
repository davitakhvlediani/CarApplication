package com.davit.carApplication.repostories;

import com.davit.carApplication.model.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CommonRepository<Car> {

}
