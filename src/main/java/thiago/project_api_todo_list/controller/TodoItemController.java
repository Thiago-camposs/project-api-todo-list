package thiago.project_api_todo_list.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import thiago.project_api_todo_list.domain.model.TodoItem;
import thiago.project_api_todo_list.service.TodoItemService;

import java.net.URI;

@RestController
@RequestMapping("/todoItems")
public class TodoItemController {

    private final TodoItemService todoItemService;

    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItem>findById(@PathVariable Long id){
        var todoItem = todoItemService.findById(id);
        return ResponseEntity.ok(todoItem);
    }

    @PostMapping
    public ResponseEntity<TodoItem>create(@RequestBody TodoItem todoItemToCreate){
        var todoItemCreated = todoItemService.create(todoItemToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(todoItemCreated.getId())
                .toUri();
        return  ResponseEntity.created(location).body(todoItemCreated);
    }
}
