package com.todoapp.todoapp.Service;

import java.util.List;
import com.todoapp.todoapp.Entity.Todo;
import com.todoapp.todoapp.Repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Component
public class TodoServiceImpl implements TodoService{

    TodoRepository todoRepository;
    @Override
    public Todo addTask(Todo todo) {
      todoRepository.save(todo);
        return todo;
    }

    @Override
    public List<Todo> getAllTask() {
        return todoRepository.findAll();
    }

    @Override
    public Long deleteTask(Long id) {
        todoRepository.deleteById(id);
        return id;
    }

    @Override
    public Todo updateTask(Todo todo) {

      Todo updateTask = todoRepository.findById(todo.getId()).get();

      System.out.println("id"+ updateTask.getId());
      updateTask.setTask(todo.getTask());
      updateTask.setChecked(todo.getChecked());
      System.out.println("update "+updateTask);
      return todoRepository.save(updateTask);
    }
}
