package co.barcochrist.todoapp.presentation.presenter;

import java.util.List;

import co.barcochrist.todoapp.domain.model.Todo;

/**
 * Created by christianbarco on 8/12/17.
 */

public interface TodoListContract {

    interface View {

        void refreshTodos();

    }

    interface UserActionsListener {

        void loadAll();

        List<Todo> getListTodos();

    }
}
