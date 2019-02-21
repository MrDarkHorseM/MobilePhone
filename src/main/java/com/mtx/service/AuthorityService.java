package com.mtx.service;

import com.mtx.domain.Authority;
import com.mtx.domain.User;
import com.mtx.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepository authorityRepository;

    public List<Authority> findAuthoritiesByUserId(Long userId){return authorityRepository.findAuthoritiesByUserId(userId);}

}
