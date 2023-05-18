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

    public void clickCheckBox(
            Long todoId
    ) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(); // 반환형을 Optional이 아닌 Todo로 하기 위한 예외처리

        todo.clickCheckBox();
    }
}
