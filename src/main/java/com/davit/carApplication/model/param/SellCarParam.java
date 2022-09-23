package com.davit.carApplication.model.param;

import lombok.Data;

@Data
public class SellCarParam {
    private Long modelId;
    private Long countryId;
    private Long quantity;
    private Double payedAmount;
}
