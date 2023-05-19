package domain.todo.service;

import domain.todo.controller.dto.request.TodoCreateRequest;
import domain.todo.controller.dto.request.TodoUpdateRequest;
import domain.todo.entity.Todo;
import domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public void addOrder(
            TodoCreateRequest request
    ) {
            todoRepository.save(
                    Todo.builder()
                            .content(request.getContent())
                            .build());
    }

    @Transactional
    public void removeOrder(
            Long todoId
    ) {
        todoRepository.deleteById(todoId);
    }

    @Transactional
    public void clickCheckBox(
            Long todoId
    ) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(); // 반환형을 Optional이 아닌 Todo로 하기 위한 예외처리

        todo.clickCheckBox();
    }
//findByAccountId(String accountId) -> O = 중복, X = 사용 가능
    @Transactional
    public void modifyOrder(
            Long todoId, TodoUpdateRequest request
    ) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow();

        todo.update(request);
    }
}
