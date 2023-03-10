package com.todo.todo_list.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.todo.todo_list.Model.ToDo_Items;
import com.todo.todo_list.Repository.Todo_Repository;



/*Here we are adding two tasks to the database as soon as the application starts to run
using the command line runner*/
@Component
public class ToDo_dataLoder implements CommandLineRunner {
    
    Logger logger = LoggerFactory.getLogger(ToDo_dataLoder.class);

    @Autowired
    Todo_Repository todo_reop;

    // over riding the run method from command line runner
    @Override
    public void run(String... args)  throws Exception{
        loading();
    }

    // Both the Task, if todorepo is empty
    private void loading() {
        if(todo_reop.count()==0){
            ToDo_Items item1 = new ToDo_Items("Compelte task 1");
            ToDo_Items item2 = new ToDo_Items("Compelete task 2");
            todo_reop.save(item1);
            todo_reop.save(item2);

            
        }
        //logs the info in console for testing purpose
        logger.info("Number {}", todo_reop.count());


    }

}
