package com.davit.carApplication.facade;

import com.davit.carApplication.model.domain.Car;
import com.davit.carApplication.model.domain.Model;
import com.davit.carApplication.model.dto.CarDTO;
import com.davit.carApplication.model.dto.ModelDTO;
import com.davit.carApplication.model.enums.CarStatus;
import com.davit.carApplication.model.mapper.CarMapper;
import com.davit.carApplication.model.mapper.ModelMapper;
import com.davit.carApplication.model.param.CarCreateParam;
import com.davit.carApplication.model.param.ModelCreateParam;
import com.davit.carApplication.service.ModelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ModelFacade {
    private final ModelService modelService;

    public ModelFacade(ModelService modelService) {
        this.modelService = modelService;
    }

    public Page<ModelDTO> getAllCar(Pageable pageable){
        Page<Model> all = modelService.getAll(pageable);
        return   all.map(ModelMapper::mapModelToDTO);
    }

    public ModelDTO getModelById(Long id){
        Model model = modelService.get(id);
        return ModelMapper.mapModelToDTO(model);
    }

    public ModelDTO saveModel(ModelCreateParam param){
        Model model = ModelMapper.mapParamToModel(param);
        Model savedModel = modelService.create(model);
        return ModelMapper.mapModelToDTO(savedModel);
    }
}
