package domain.todo.service;

import domain.todo.controller.dto.request.TodoCreateRequest;
import domain.todo.entity.Todo;
import domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public void addTodo(
            TodoCreateRequest request
    ) {
            todoRepository.save(
                    Todo.builder()
                            .content(request.getContent())
                            .build());
    }

    public void deleteTodo(
            Long todoId
    ) {
        todoRepository.deleteById(todoId);
    }
}
