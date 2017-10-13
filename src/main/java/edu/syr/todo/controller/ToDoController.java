package edu.syr.todo.controller;

import edu.syr.todo.entities.ToDo;
import edu.syr.todo.repository.ToDoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/todo/api")
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<ToDo> create(@RequestBody ToDo todo) {

        ToDo todoRepsonse = toDoRepository.save(todo);

        return new ResponseEntity<ToDo>(todoRepsonse, HttpStatus.OK);
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<Collection<ToDo>> getTodos() {
        List<ToDo> listOfToDos = toDoRepository.findAll();
        return new ResponseEntity<Collection<ToDo>>(listOfToDos, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<ToDo> getToDo(@PathVariable Long id) {
        ToDo toDo = toDoRepository.findOne(id);

        if(toDo == null) {
            return new ResponseEntity<ToDo>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<ToDo>(toDo, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<ToDo> updateToDO (@PathVariable Long id,@RequestBody ToDo toDo) {
        ToDo savedToDo = toDoRepository.findOne(id);

        if(toDo == null) {
            return new ResponseEntity<ToDo>(HttpStatus.NO_CONTENT);
        }

        BeanUtils.copyProperties(toDo, savedToDo, "id");
        savedToDo = toDoRepository.save(savedToDo);
        return  new ResponseEntity<ToDo>(savedToDo, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ToDo> deleteToDo (@PathVariable Long id) {
        ToDo toDo = toDoRepository.findOne(id);

        if(toDo == null) {
            return new ResponseEntity<ToDo>(HttpStatus.NO_CONTENT);
        }
        try {
            toDoRepository.delete(toDo);
        } catch (Exception e) {
            return new ResponseEntity<ToDo>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<ToDo>(HttpStatus.NO_CONTENT);
    }

}
