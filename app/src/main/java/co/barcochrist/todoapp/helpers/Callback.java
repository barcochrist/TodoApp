package co.barcochrist.todoapp.helpers;

/**
 * Created by christianbarco on 5/12/17.
 */

public interface Callback<T> {
    void success(T result);
    void error(Exception error);
}
