package com.davit.carApplication.controller;

import com.davit.carApplication.facade.CarFacade;
import com.davit.carApplication.model.dto.CarDTO;
import com.davit.carApplication.model.param.CarCreateParam;
import com.davit.carApplication.model.param.CarUpdateParam;
import lombok.RequiredArgsConstructor;
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
public class CarController {

    private final CarFacade carFacade;


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CarDTO> create(
            @RequestBody CarCreateParam carCreateParam
    ){
      return ResponseEntity.ok(carFacade.saveCar(carCreateParam));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<CarDTO> update(
            @PathVariable Long id,
            @RequestBody CarUpdateParam carUpdateParam
    ){
        return ResponseEntity.ok(carFacade.updateCar(id, carUpdateParam));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(
          @PathVariable Long id
    ){
        carFacade.delete(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> get(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(carFacade.getCarById(id));
    }

    @GetMapping
    public ResponseEntity<Page<CarDTO>> getAll(
           @PageableDefault(value=0, size = 50, sort=("id"), direction = Sort.Direction.ASC)
            Pageable page
    ){
        return ResponseEntity.ok(carFacade.getAllCar(page));
    }

}
