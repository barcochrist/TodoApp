package co.barcochrist.todoapp.presentation.presenter;

import co.barcochrist.todoapp.domain.model.User;
import co.barcochrist.todoapp.domain.usecase.UserUseCase;
import co.barcochrist.todoapp.domain.usecase.impl.UserUseCaseImpl;
import co.barcochrist.todoapp.helpers.Callback;

/**
 * Created by christianbarco on 30/11/17.
 */

public class LoginPresenter implements LoginContract.UserActionsListeners {

    private LoginContract.View view;
    private UserUseCase userUseCase;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.userUseCase = new UserUseCaseImpl();
    }

    @Override
    public void onLogin(String email, String password, boolean remember) {
        view.showProgress();
        userUseCase.login(email, password, remember, new Callback<User>() {
            @Override
            public void success(User user) {
                view.hideProgress();
                view.goToMainActivity();
            }

            @Override
            public void error(Exception error) {
                view.hideProgress();
                view.showMessageError(error);
            }
        });
    }
}
