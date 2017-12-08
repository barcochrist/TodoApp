package co.barcochrist.todoapp.repository.impl;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import co.barcochrist.todoapp.database.AppDatabase;
import co.barcochrist.todoapp.domain.model.Todo;
import co.barcochrist.todoapp.repository.TodoRepository;

/**
 * Created by christianbarco on 5/12/17.
 * Una implementación para el almacenamiento local con SQLite.
 * se pueden crear más implementaciones para cada fuente de datos.
 */

public class TodoLocalRepository implements TodoRepository {

    @Dao
    public interface TodoDao {
        @Insert
        void insert(Todo todo);

        @Update
        void update(Todo todo);

        @Delete
        void delete(Todo todo);

        @Query("select * from todo")
        List<Todo> getAll();
    }

    @Override
    public void insert(Todo todo) {
        AppDatabase db = AppDatabase.getInstance();
        TodoDao todoDao = db.todoDao();
        todoDao.insert(todo);
    }

    @Override
    public void update(Todo todo) {
        //TODO IMPLEMENTAR
    }

    @Override
    public void delete(Todo todo) {
        //TODO IMPLEMETAR
    }

    @Override
    public List<Todo> getAll() {
        AppDatabase db = AppDatabase.getInstance();
        TodoDao todoDao = db.todoDao();
        return todoDao.getAll();
    }
}
