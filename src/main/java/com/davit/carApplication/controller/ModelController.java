package com.davit.carApplication.controller;

import com.davit.carApplication.facade.ModelFacade;
import com.davit.carApplication.model.dto.ModelDTO;
import com.davit.carApplication.model.dto.TransactionDto;
import com.davit.carApplication.model.param.ModelCreateParam;
import com.davit.carApplication.model.param.ModelUpdateParam;
import com.davit.carApplication.model.param.SellCarParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/model")
@RequiredArgsConstructor
public class ModelController {

    private final ModelFacade modelFacade;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ModelDTO> create(
            @RequestBody ModelCreateParam modelDTO
    ){
      return ResponseEntity.ok(modelFacade.saveModel(modelDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelDTO> update(
            @PathVariable Long id,
            @RequestBody ModelUpdateParam modelUpdateParam
    ){
        return ResponseEntity.ok(modelFacade.updateModel(id, modelUpdateParam));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(
          @PathVariable Long id
    ){
        modelFacade.deleteModel(id);
        return ResponseEntity.ok(null);
    }


    @PostMapping("/buy")
    public ResponseEntity<TransactionDto> buy(
            @RequestBody SellCarParam sellCarParam
            ){
        return ResponseEntity.ok(modelFacade.sellCar(sellCarParam));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelDTO> get(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(modelFacade.getModelById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ModelDTO>> getAll(
           @PageableDefault(value=0, size = 50, sort=("id"), direction = Sort.Direction.ASC)
            Pageable page,
           @RequestParam(required = false, value = "search") String search
    ){
        return ResponseEntity.ok(modelFacade.getAllModel(page, search));
    }

}
