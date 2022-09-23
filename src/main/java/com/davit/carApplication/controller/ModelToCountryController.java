package com.davit.carApplication.controller;

import com.davit.carApplication.facade.ModelToCountryFacade;
import com.davit.carApplication.model.dto.ModelToCountryDTO;
import com.davit.carApplication.model.param.ModelToCountryParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mtc")
@RequiredArgsConstructor
public class ModelToCountryController {

    private final ModelToCountryFacade modelToCountryFacade;
    @PostMapping
    public ResponseEntity<ModelToCountryDTO> createModelToCar(@RequestBody ModelToCountryParam param){
        return ResponseEntity.ok(modelToCountryFacade.createModelToCar(param));
    }
}
