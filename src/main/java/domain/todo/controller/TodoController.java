package domain.todo.controller;

import domain.todo.controller.dto.request.TodoCreateRequest;
import domain.todo.controller.dto.request.TodoUpdateRequest;
import domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/todo")
@RestController
@RequiredArgsConstructor
public class TodoController {

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

    @PostMapping("/{todoId}")
    public void clickCheckBox(
            @PathVariable Long todoId
    ) {
        todoService.clickCheckBox(todoId);
    }

    @PutMapping("/{todoId}")
    public void update(
            @PathVariable Long id,
            @Valid @RequestBody TodoUpdateRequest todoUpdateRequest
    ) {
        todoService.update(id, todoUpdateRequest);
    }

}
