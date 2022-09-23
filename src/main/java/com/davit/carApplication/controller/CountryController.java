package com.davit.carApplication.controller;

import com.davit.carApplication.facade.CountryFacade;
import com.davit.carApplication.model.dto.CarDTO;
import com.davit.carApplication.model.dto.CountryDTO;
import com.davit.carApplication.model.param.CountryCreateParam;
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
@RequestMapping("/api/country")
@RequiredArgsConstructor
@Tag(name = "Country", description = "Country API")
public class CountryController {

    private final CountryFacade countryFacade;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create country")
    public ResponseEntity<CountryDTO> createCountry(
            @RequestBody CountryCreateParam countryCreateParam
            ){
       return ResponseEntity.ok(countryFacade.saveCountry(countryCreateParam));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get country by id")
    public ResponseEntity<CountryDTO> getCountry(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(countryFacade.getCountryById(id));
    }

    @GetMapping
    @Operation(summary = "Get all countries")
    @PageableAsQueryParam
    public ResponseEntity<Page<CountryDTO>> getAll(
            @PageableDefault(value = 0, size = 50, sort = ("id"), direction = Sort.Direction.ASC)
            Pageable page,
            @RequestParam(required = false, value = "search") String search
    ) {
        return ResponseEntity.ok(countryFacade.getAllCountry(page, search));
    }


}
