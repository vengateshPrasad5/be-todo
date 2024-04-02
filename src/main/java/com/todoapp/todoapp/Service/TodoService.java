package com.todoapp.todoapp.Service;

import com.todoapp.todoapp.Entity.Todo;

import java.util.List;

public interface TodoService  {

   Todo addTask(Todo todo);

   List<Todo> getAllTask();

   Long deleteTask(Long id);

   Todo updateTask(Todo todo);
}
