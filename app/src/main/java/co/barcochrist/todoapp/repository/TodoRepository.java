package co.barcochrist.todoapp.repository;

import java.util.List;

import co.barcochrist.todoapp.domain.model.Todo;

/**
 * Created by christianbarco on 5/12/17.
 * Tendra los metodos necesarios para gestionar los Todos.
 */

public interface TodoRepository {
    void insert(Todo todo);

    void update(Todo todo);

    void delete(Todo todo);

    List<Todo> getAll();
}
