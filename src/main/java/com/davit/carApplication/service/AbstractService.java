package com.davit.carApplication.service;

import com.davit.carApplication.repostories.CommonRepository;
import com.github.ichanzhar.rsql.JpaRsqlVisitor;
import com.github.ichanzhar.rsql.utils.RsqlParserFactory;
import cz.jirutka.rsql.parser.ast.Node;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
public abstract class AbstractService<E, R extends CommonRepository<E>> {

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

    public Page<E> getAll(Pageable page, String search) {
        if(search != null){
            Node rootNode = RsqlParserFactory.INSTANCE.instance().parse(search);
            Specification<E> spec = rootNode.accept(new JpaRsqlVisitor<>());
            return repository.findAll(spec, page);
        }

        return repository.findAll(page);
    }
}
