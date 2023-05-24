package com.example.springtodo.domain.todo.service;

import com.example.springtodo.domain.todo.controller.dto.response.TodoListResponse;
import com.example.springtodo.domain.todo.controller.dto.request.TodoCreateRequest;
import com.example.springtodo.domain.todo.controller.dto.request.TodoUpdateRequest;
import com.example.springtodo.domain.todo.controller.dto.response.TodoResponse;
import com.example.springtodo.domain.todo.entity.Todo;
import com.example.springtodo.domain.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
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

    public void removeTodo(
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

    //findByAccountId(String accountId) -> O = 중복, X = 사용 가능
    public void modifyTodo(
            Long todoId, TodoUpdateRequest request
    ) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow();

        todo.update(request);
    }

    @Transactional(readOnly = true)
    public TodoListResponse listTodo() {
        return TodoListResponse.builder()
                .todoList(
                        todoRepository.findAll()
                                .stream()
                                .map(TodoResponse::of)
                                .toList()
                )
                .build();
    }


}