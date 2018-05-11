package com.myspringbootapps.springDataplusValidation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myspringbootapps.springDataplusValidation.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer>
{
    public User findByUsername(String username);
}
