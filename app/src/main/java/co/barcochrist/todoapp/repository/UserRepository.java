package co.barcochrist.todoapp.repository;

import co.barcochrist.todoapp.domain.model.User;
import co.barcochrist.todoapp.helpers.Callback;

/**
 * Created by christianbarco on 30/11/17.
 */

public interface UserRepository {

    void login(String email, String password, Callback<User> callback);

    void signUp(User user, Callback<User> callback);

    void recoveryPassword(String email, Callback<Boolean> callback);
}
