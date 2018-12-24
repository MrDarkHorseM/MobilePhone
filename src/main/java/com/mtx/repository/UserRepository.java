package com.mtx.repository;


import com.mtx.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    @Query("Select c FROM #{#entityName} c LEFT JOIN FETCH c.images")
    List<User> findAllWithImages();

    @Query("select c FROM #{#entityName} c LEFT JOIN FETCH c.images where c.id = ?1")
    Optional<User> findByIdwithImages(Long Id);
}
