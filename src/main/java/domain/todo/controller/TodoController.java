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
    public void orderAdd (
            @RequestBody TodoCreateRequest request
            ) {
        todoService.addOrder(request);
    }

    @DeleteMapping("/{todoId}")
    public void orderRemove(
            @PathVariable Long todoId
    ) {
        todoService.removeOrder(todoId);
    }

    @PostMapping("/{todoId}")
    public void clickCheckBox(
            @PathVariable Long todoId
    ) {
        todoService.clickCheckBox(todoId);
    }

    @PutMapping("/{todoId}")
    public void orderModify(
            @PathVariable Long id,
            @Valid @RequestBody TodoUpdateRequest todoUpdateRequest
    ) {
        todoService.modifyOrder(id, todoUpdateRequest);
    }

}
