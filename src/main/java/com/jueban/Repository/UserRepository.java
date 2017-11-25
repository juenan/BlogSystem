package com.jueban.Repository;

import com.jueban.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
    public User findByName(String name);
}
