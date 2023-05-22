package domain.todo.entity;

import domain.todo.controller.dto.request.TodoUpdateRequest;
import domain.todo.controller.dto.response.TodoListResponse;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private boolean isChecked = false;

    public void clickCheckBox(){
        this.isChecked = !this.isChecked;
    }

    public void update(
            TodoUpdateRequest request
    ) {
        this.content = request.getContent();
    }

    @Builder
    public Todo(
            String content,
            boolean isChecked
    ) {
        this.content = content;
        this.isChecked = isChecked;
    }
}
