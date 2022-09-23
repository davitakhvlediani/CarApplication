package com.davit.carApplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
public abstract class AbstractService<E, R extends JpaRepository<E, Long>> {

    protected final R repository;


    public E create(E entity) {
        return repository.save(entity);
    }

    public E update(Long id, E entity) {
        E storedCar = get(id);
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public E get(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource Not Found"));
    }

    public Page<E> getAll(Pageable page) {
        return repository.findAll(page);
    }
}
