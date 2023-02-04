package com.todo.todo_list.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.todo.todo_list.Model.ToDo_Items;
import com.todo.todo_list.Repository.Todo_Repository;

@Controller
public class ToDo_Controller {
    
    @Autowired
    private Todo_Repository todoItemRepository;
   
    // adds two Task from the datalodder
    @GetMapping("/")
    public ModelAndView index(){
         ModelAndView modelAndView = new ModelAndView("index.html");
         modelAndView.addObject("todoItems", todoItemRepository.findAll());
        return modelAndView;

    }
    
    //deletes Tasks
     @GetMapping("/delete")
    public String showUpdateForm(@RequestParam Integer Id,Model model){
        ToDo_Items todoitems =todoItemRepository.findById(Id).orElseThrow(()-> new IllegalArgumentException("No such element in to do list") );
        todoItemRepository.delete(todoitems);
        return "redirect:/";
    }

    // Adds Tasks
    @GetMapping("/add")
    public String addItems(Model model){
        model.addAttribute("added", new ToDo_Items());
        return "update-todo-items.html";

    }

    // saves tasks to H2
    @PostMapping("/handleSubmit")
    public String dataFromForm(ToDo_Items todo){
        todoItemRepository.save(todo);
        return "redirect:/";
    }

   

}
