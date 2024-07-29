package thiago.project_api_todo_list.service.impl;

import org.springframework.stereotype.Service;
import thiago.project_api_todo_list.domain.model.TodoItem;
import thiago.project_api_todo_list.domain.repository.TodoItemRepository;
import thiago.project_api_todo_list.service.TodoItemService;

import java.util.NoSuchElementException;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoItemRepository todoItemRepository;

    public TodoItemServiceImpl(TodoItemRepository todoItemRepository) {
        this.todoItemRepository = todoItemRepository;
    }

    @Override
    public TodoItem findById(Long id) {
        return todoItemRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public TodoItem create(TodoItem todoItemToCreate) {
        if (todoItemToCreate.getId() != null && todoItemRepository.existsById(todoItemToCreate.getId())){
            throw new IllegalArgumentException("This Item ID already exists.");
        }
        return todoItemRepository.save(todoItemToCreate);
    }
}

