package com.davit.carApplication.controller;

import com.davit.carApplication.model.dto.CarDTO;
import com.davit.carApplication.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;


    @PostMapping
    public ResponseEntity<CarDTO> create(
            @RequestBody CarDTO carDTO
    ){
      return ResponseEntity.ok(carService.create(carDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarDTO> update(
            @PathVariable Long id,
            @RequestBody CarDTO carDTO
    ){
        return ResponseEntity.ok(carService.update(id, carDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
          @PathVariable Long id
    ){
        carService.delete(id);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> get(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(carService.get(id));
    }

    @GetMapping
    public ResponseEntity<Page<CarDTO>> getAll(
           @PageableDefault(value=0, size = 50, sort=("id"), direction = Sort.Direction.ASC)
            Pageable page
    ){
        return ResponseEntity.ok(carService.getAll(page));
    }

}
