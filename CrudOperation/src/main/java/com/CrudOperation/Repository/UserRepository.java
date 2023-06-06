package com.CrudOperation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CrudOperation.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
