package domain.todo.controller;

import domain.todo.controller.dto.request.TodoCreateRequest;
import domain.todo.repository.TodoRepository;
import domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/todo")
@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository todoRepository;

    private final TodoService todoService;

    @PostMapping
    public void todoAdd(
            @RequestBody TodoCreateRequest request
            ) {
        todoService.addTodo(request);
    }

    @DeleteMapping("/{todoId}")
    public void todoRemove(
            @PathVariable Long todoId
    ) {
        todoService.deleteTodo(todoId);
    }
}
