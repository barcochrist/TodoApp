package co.barcochrist.todoapp.presentation.presenter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.barcochrist.todoapp.domain.model.Todo;
import co.barcochrist.todoapp.domain.usecase.TodoUseCase;
import co.barcochrist.todoapp.domain.usecase.impl.TodoUseCaseImpl;
import co.barcochrist.todoapp.helpers.Callback;

/**
 * Created by christianbarco on 8/12/17.
 */

public class TodoListPresenter implements TodoListContract.UserActionsListener{

    private TodoListContract.View view;
    private TodoUseCase todoUseCase;
    private List<Todo> listTodos;


    public TodoListPresenter(TodoListContract.View view) {
        this.view = view;
        todoUseCase = new TodoUseCaseImpl();
        listTodos = new ArrayList<>(0);
    }

    @Override
    public void loadAll() {
        todoUseCase.getAll(new Callback<List<Todo>>() {
            @Override
            public void success(List<Todo> result) {
                //Se eliminan para evitar que el adapter tenga una referencia
                //a una lista antigua
                listTodos.clear();
                listTodos.addAll(result);
            }

            @Override
            public void error(Exception error) {
                //TODO Mostrar mensaje de error
            }
        });
    }

    @Override
    public List<Todo> getListTodos() {
        return listTodos;
    }
}
