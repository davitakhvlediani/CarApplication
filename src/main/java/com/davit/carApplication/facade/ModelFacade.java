package com.davit.carApplication.facade;

import com.davit.carApplication.model.domain.Car;
import com.davit.carApplication.model.domain.Model;
import com.davit.carApplication.model.domain.ModelToCountry;
import com.davit.carApplication.model.domain.UserTransaction;
import com.davit.carApplication.model.dto.ModelDTO;
import com.davit.carApplication.model.dto.TransactionDto;
import com.davit.carApplication.model.enums.ModelToCountryStatus;
import com.davit.carApplication.model.mapper.ModelMapper;
import com.davit.carApplication.model.mapper.UserTransactionMapper;
import com.davit.carApplication.model.param.ModelCreateParam;
import com.davit.carApplication.model.param.ModelUpdateParam;
import com.davit.carApplication.model.param.SellCarParam;
import com.davit.carApplication.service.CarService;
import com.davit.carApplication.service.ModelService;
import com.davit.carApplication.service.ModelToCountryService;
import com.davit.carApplication.service.UserTransactionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class ModelFacade {
    private final ModelService modelService;
    private final CarService carService;
    private final ModelToCountryService modelToCountryService;
    private final UserTransactionService userTransactionService;

    public ModelFacade(ModelService modelService, CarService carService, ModelToCountryService modelToCountryService, UserTransactionService userTransactionService) {
        this.modelService = modelService;
        this.carService = carService;
        this.modelToCountryService = modelToCountryService;
        this.userTransactionService = userTransactionService;
    }

    public Page<ModelDTO> getAllModel(Pageable pageable, String search) {
        Page<Model> all = modelService.getAll(pageable, search);
        return all.map(ModelMapper::mapModelToDTO);
    }

    public ModelDTO getModelById(Long id) {
        Model model = modelService.get(id);
        return ModelMapper.mapModelToDTO(model);
    }

    public ModelDTO saveModel(ModelCreateParam param) {
        Model model = ModelMapper.mapParamToModel(param);
        Car car = carService.get(param.getCarId());
        model.setCar(car);
        Model savedModel = modelService.create(model);


        return ModelMapper.mapModelToDTO(savedModel);
    }

    public void deleteModel(Long id) {
        modelService.delete(id);
    }

    public TransactionDto sellCar(SellCarParam param) {
        ModelToCountry modelToCountry = modelToCountryService.findModelToCountryByModelAndCountry(param.getModelId(), param.getCountryId());
        if (!modelToCountry.getStatus().equals(ModelToCountryStatus.ACTIVE)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (modelToCountry.getQuantity() < param.getQuantity()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough amount!");
        }
        double amountToPay = modelToCountry.getModel().getPrice() * param.getQuantity();
        if (amountToPay > param.getPayedAmount()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not enough payed!");
        }
        modelToCountry.setQuantity(modelToCountry.getQuantity() - param.getQuantity());
        UserTransaction userTransaction = new UserTransaction();
        userTransaction.setBoughtCarModel(modelToCountry.getModel());
        userTransaction.setBoughtTime(LocalDateTime.now());
        userTransaction.setCountry(modelToCountry.getCountry());
        userTransaction.setPayedAmount(param.getPayedAmount());
        userTransaction.setTotalCost(amountToPay);
        UserTransaction savedTransaction = userTransactionService.create(userTransaction);
        modelToCountryService.update(modelToCountry.getId(), modelToCountry);
        return UserTransactionMapper.mapUserTransactionToDTO(savedTransaction);
    }

    public ModelDTO updateModel(Long id, ModelUpdateParam modelUpdateParam) {
        Model model = modelService.get(id);
        model.setPrice(modelUpdateParam.getPrice());
        return ModelMapper.mapModelToDTO(modelService.update(id, model));
    }
}
