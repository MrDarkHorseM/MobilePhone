package com.mtx.repository;

import com.mtx.domain.Authority;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {

//    List<Authority> findAll();
//
//    Optional<Authority> findById();
//
//    @Query("select a from Authority a LEFT JOIN a.user Users where user_id = ?1")
//    List<Authority> findAuthoritiesByUserId (Long userId);

}
