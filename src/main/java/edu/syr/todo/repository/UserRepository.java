package edu.syr.todo.repository;

import edu.syr.todo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Long>{
    public User findByUsername(String username);
}