package com.todo.todo_list.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "todo_item")

public class ToDo_Items {
    
    public ToDo_Items() {}
    
    public ToDo_Items(String discription) {
        this.discription = discription;
        this.complete = false;
    
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    @NotNull
    private Integer id;
    
    
    @Getter
    @Setter
    @NotBlank(message = "Description is required")
    private String discription;
    @Getter
    @Setter
    private boolean complete;
    



   
}
