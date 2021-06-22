package com.demo.library.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.library.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer>{

}
