package entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class TodoList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private STATUS status;

    public TodoList() {
    }

    public TodoList(String title, String description) {
        this.title = title;
        this.description = description;
        this.status = STATUS.PENDENTE;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Título: " + title +
                " | Descrição: " + description +
                " | Status: " + status;
    }
}
