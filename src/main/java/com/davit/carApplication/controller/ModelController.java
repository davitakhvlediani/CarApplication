package com.davit.carApplication.controller;

import com.davit.carApplication.facade.ModelFacade;
import com.davit.carApplication.model.dto.ModelDTO;
import com.davit.carApplication.model.dto.TransactionDto;
import com.davit.carApplication.model.param.ModelCreateParam;
import com.davit.carApplication.model.param.ModelUpdateParam;
import com.davit.carApplication.model.param.SellCarParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Model", description = "Model API")
public class ModelController {

    private final ModelFacade modelFacade;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create model")
    public ResponseEntity<ModelDTO> create(
            @RequestBody ModelCreateParam modelDTO
    ){
      return ResponseEntity.ok(modelFacade.saveModel(modelDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update model")
    public ResponseEntity<ModelDTO> update(
            @PathVariable Long id,
            @RequestBody ModelUpdateParam modelUpdateParam
    ){
        return ResponseEntity.ok(modelFacade.updateModel(id, modelUpdateParam));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete model")
    public ResponseEntity<Void> delete(
          @PathVariable Long id
    ){
        modelFacade.deleteModel(id);
        return ResponseEntity.ok(null);
    }


    @PostMapping("/buy")
    @Operation(summary = "Buy car")
    public ResponseEntity<TransactionDto> buy(
            @RequestBody SellCarParam sellCarParam
            ){
        return ResponseEntity.ok(modelFacade.sellCar(sellCarParam));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get model by id")
    public ResponseEntity<ModelDTO> get(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(modelFacade.getModelById(id));
    }

    @GetMapping
    @Operation(summary = "Get all models")
    public ResponseEntity<Page<ModelDTO>> getAll(
           @PageableDefault(value=0, size = 50, sort=("id"), direction = Sort.Direction.ASC)
            Pageable page,
           @RequestParam(required = false, value = "search") String search
    ){
        return ResponseEntity.ok(modelFacade.getAllModel(page, search));
    }

}
