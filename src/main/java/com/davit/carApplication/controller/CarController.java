package com.davit.carApplication.controller;

import com.davit.carApplication.facade.CarFacade;
import com.davit.carApplication.model.dto.CarDTO;
import com.davit.carApplication.model.param.CarCreateParam;
import com.davit.carApplication.model.param.CarUpdateParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
@Tag(name = "Car", description = "Car API")
public class CarController {

    private final CarFacade carFacade;


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create car")
    public ResponseEntity<CarDTO> create(
            @RequestBody CarCreateParam carCreateParam
    ) {
        return ResponseEntity.ok(carFacade.saveCar(carCreateParam));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update car")
    public ResponseEntity<CarDTO> update(
            @PathVariable Long id,
            @RequestBody CarUpdateParam carUpdateParam
    ) {
        return ResponseEntity.ok(carFacade.updateCar(id, carUpdateParam));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete car")
    public ResponseEntity<Void> delete(
            @PathVariable Long id
    ) {
        carFacade.delete(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get car by id")
    public ResponseEntity<CarDTO> get(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(carFacade.getCarById(id));
    }

    @GetMapping
    @Operation(summary = "Get all cars")
    @PageableAsQueryParam
    public ResponseEntity<Page<CarDTO>> getAll(
            @PageableDefault(value = 0, size = 50, sort = ("id"), direction = Sort.Direction.ASC)
            Pageable page,
            @RequestParam(required = false, value = "search") String search
    ) {
        return ResponseEntity.ok(carFacade.getAllCar(page, search));
    }

}
