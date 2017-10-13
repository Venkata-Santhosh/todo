package edu.syr.todo.repository;

import edu.syr.todo.entities.ToDo;
import edu.syr.todo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo,Long> {
    public ToDo findByTaskAndUser(String task, User user);
}
