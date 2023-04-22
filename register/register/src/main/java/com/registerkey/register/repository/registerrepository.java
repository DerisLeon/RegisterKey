package com.registerkey.register.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.registerkey.register.model.registermodel;

@Repository
public interface registerrepository extends CrudRepository<registermodel, Long> {}
