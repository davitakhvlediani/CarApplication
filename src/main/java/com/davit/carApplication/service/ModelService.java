package com.davit.carApplication.service;


import com.davit.carApplication.model.domain.Model;
import com.davit.carApplication.repostories.ModelRepository;

import org.springframework.stereotype.Service;

@Service
public class ModelService extends AbstractService<Model, ModelRepository>{


    public ModelService(ModelRepository repository) {
        super(repository);
    }
}