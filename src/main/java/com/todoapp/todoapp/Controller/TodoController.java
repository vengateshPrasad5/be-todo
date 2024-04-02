package com.todoapp.todoapp.Controller;

import com.todoapp.todoapp.Entity.Todo;
import com.todoapp.todoapp.Service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.todoapp.todoapp.Response.ResponseHandler.generateResponse;


@RestController
@CrossOrigin(origins = "http://localhost:3000/",
        methods =   {   RequestMethod.OPTIONS,
                        RequestMethod.GET,
                        RequestMethod.PUT,
                        RequestMethod.PATCH,
                        RequestMethod.DELETE,
                        RequestMethod.POST     }
)
@RequestMapping("/api/v1")
public class TodoController {

    @Autowired
    private TodoServiceImpl todoServiceImpl;

    @GetMapping()
    public ResponseEntity<String> home (){
        return new ResponseEntity<>("Backend Connected on Server 8080",HttpStatus.OK);
    }
    @PostMapping("/addTask")
    public ResponseEntity<Todo> addTask(@RequestBody Todo todo){
       Todo addTask = todoServiceImpl.addTask(todo);
       return new ResponseEntity<>(addTask, HttpStatus.CREATED);
    }

    @GetMapping("/getTask")
    public ResponseEntity<Object> getTask(){
        List<Todo> taskList = todoServiceImpl.getAllTask();
        System.out.println(taskList);

        return  generateResponse(HttpStatus.OK, "Data Fetched",taskList);
    }

    @PutMapping("/updateTask")
    public ResponseEntity<Object> updateTask(@RequestBody Todo todo){
        todoServiceImpl.updateTask(todo);
        System.out.println(todo);
        return new ResponseEntity<>("id "+todo.getId()+" updated successfully",HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<Object>deleteTask(@PathVariable("id") Long id){
        todoServiceImpl.deleteTask(id);
        System.out.println(id);
        return new ResponseEntity<>("Record Deleted Successfully", HttpStatus.OK);
    }

}
