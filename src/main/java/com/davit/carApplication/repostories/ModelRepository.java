package com.davit.carApplication.repostories;

import com.davit.carApplication.model.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends CommonRepository<Model>{

}
