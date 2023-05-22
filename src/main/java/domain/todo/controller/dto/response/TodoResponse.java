package domain.todo.controller.dto.response;

import domain.todo.entity.Todo;
import lombok.Builder;

@Builder
public class TodoResponse {

    private Long id;

    private String content;

    private boolean isChecked;

    public static TodoResponse of(Todo todo){

        return TodoResponse.builder()
                .id(todo.getId())
                .content(todo.getContent())
                .isChecked(todo.isChecked())
                .build();
    }
}
