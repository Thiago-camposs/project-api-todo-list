package thiago.project_api_todo_list.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thiago.project_api_todo_list.domain.model.TodoItem;

public interface TodoItemRepository extends JpaRepository<TodoItem,Long> {
}
