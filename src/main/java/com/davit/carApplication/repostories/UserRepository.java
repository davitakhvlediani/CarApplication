package com.davit.carApplication.repostories;

import com.davit.carApplication.model.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<MyUser,Long> {

    Optional<MyUser> findUserByUsername(String username);
}
