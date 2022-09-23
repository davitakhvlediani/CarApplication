package com.davit.carApplication.model.param;

import com.davit.carApplication.model.enums.CarStatus;
import lombok.Data;

@Data
public class CarUpdateParam {

    private String carName;

    private CarStatus status;
}
