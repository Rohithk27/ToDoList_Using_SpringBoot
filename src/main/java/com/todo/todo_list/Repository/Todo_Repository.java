package com.todo.todo_list.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.todo.todo_list.Model.ToDo_Items;

@Repository
public interface Todo_Repository extends CrudRepository<ToDo_Items,Integer>{

    
    
}
