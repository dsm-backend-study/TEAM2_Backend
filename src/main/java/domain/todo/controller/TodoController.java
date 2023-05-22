package domain.todo.controller;

import domain.todo.controller.dto.request.TodoCreateRequest;
import domain.todo.controller.dto.request.TodoUpdateRequest;
import domain.todo.controller.dto.response.TodoListResponse;
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
        todoService.removeTodo(todoId);
    }

    @PostMapping("/{todoId}")
    public void clickCheckBox(
            @PathVariable Long todoId
    ) {
        todoService.clickCheckBox(todoId);
    }

    @PutMapping("/{todoId}")
    public void todoModify(
            @PathVariable Long todoId,
            @Valid @RequestBody TodoUpdateRequest todoUpdateRequest
    ) {
        todoService.modifyTodo(todoId, todoUpdateRequest);
    }

    @GetMapping
    public TodoListResponse orderList()
    {
        return todoService.listTodo();
    }
}
