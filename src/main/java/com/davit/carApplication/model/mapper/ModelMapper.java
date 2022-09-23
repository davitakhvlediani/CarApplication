package com.davit.carApplication.model.mapper;

import com.davit.carApplication.model.domain.Model;
import com.davit.carApplication.model.dto.ModelDTO;
import com.davit.carApplication.model.enums.ModelStatus;
import com.davit.carApplication.model.param.ModelCreateParam;

public class ModelMapper {

    public static ModelDTO mapModelToDTO(Model model) {
        ModelDTO modelDTO = new ModelDTO();
        modelDTO.setName(model.getName());
        modelDTO.setColor(model.getColor());
        modelDTO.setReleaseDate(model.getReleaseDate());
        modelDTO.setPrice(model.getPrice());
        modelDTO.setTradeInPercent(model.getTradeInPercent());
        modelDTO.setId(modelDTO.getId());
        return  modelDTO;
    }

    public static Model mapParamToModel(ModelCreateParam param) {
        Model model = new Model();
        model.setName(param.getName());
        model.setPrice(param.getPrice());
        model.setColor(param.getColor());
        model.setReleaseDate(param.getReleaseDate());
        model.setModelStatus(ModelStatus.ACTIVE);
        model.setTradeInPercent(param.getTradeInPercent());
        return model;
    }


}
