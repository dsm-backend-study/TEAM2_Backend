package domain.todo.entity;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private boolean isChecked = false;

    @Builder
    public Todo(
            String content,
            boolean isChecked
    ) {
        this.content = content;
        this.isChecked = isChecked;
    }
}
