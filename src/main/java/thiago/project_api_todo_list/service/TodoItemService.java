package thiago.project_api_todo_list.service;

import thiago.project_api_todo_list.domain.model.TodoItem;

public interface TodoItemService {

    TodoItem findById(Long id);

    TodoItem create(TodoItem todoItemToCreate);
}
