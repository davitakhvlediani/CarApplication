//package com.davit.carApplication.controller;
//
//import com.davit.carApplication.model.dto.ModelDTO;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/model")
//@RequiredArgsConstructor
//public class ModelController {
//
//    private ModelFacade modelFacade;
//
//    @PostMapping
//    public ResponseEntity<ModelDTO> create(
//            @RequestBody ModelDTO modelDTO
//    ){
//      return ResponseEntity.ok(modelFacade.create(modelDTO));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ModelDTO> update(
//            @PathVariable Long id,
//            @RequestBody ModelDTO modelDTO
//    ){
//        return ResponseEntity.ok(modelFacade.update(id, modelDTO));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(
//          @PathVariable Long id
//    ){
//        modelFacade.delete(id);
//        return ResponseEntity.ok(null);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<ModelDTO> get(
//            @PathVariable Long id
//    ){
//        return ResponseEntity.ok(modelFacade.get(id));
//    }
//
//    @GetMapping
//    public ResponseEntity<Page<ModelDTO>> getAll(
//           @PageableDefault(value=0, size = 50, sort=("id"), direction = Sort.Direction.ASC)
//            Pageable page
//    ){
//        return ResponseEntity.ok(modelFacade.getAll(page));
//    }
//
//}
