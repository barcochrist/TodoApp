package co.barcochrist.todoapp.domain.usecase;

import co.barcochrist.todoapp.domain.model.User;
import co.barcochrist.todoapp.helpers.Callback;

/**
 * Created by christianbarco on 5/12/17.
 */

public interface UserUseCase {

    void login(String email, String password, boolean remember, Callback<User> callback);

    void signUp(String fullName, String email, String password, Callback<User> callback);

    void recoveryPassword(String email, Callback<Boolean> callback);
}
