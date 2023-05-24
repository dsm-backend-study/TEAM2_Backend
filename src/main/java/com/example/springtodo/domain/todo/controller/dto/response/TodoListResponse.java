package com.example.springtodo.domain.todo.controller.dto.response;


import lombok.Builder;

import java.util.List;

@Builder
public class TodoListResponse {
    private List<TodoResponse> todoList;

}
