package com.davit.carApplication.model.param;

import lombok.Data;

@Data
public class TradeInParam {
    private Long modelId;
    private Long countryId;
    private Double payedAmount;
    private Long oldModelId;
}
