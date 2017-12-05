package co.barcochrist.todoapp.presentation.presenter;

import co.barcochrist.todoapp.domain.model.User;
import co.barcochrist.todoapp.domain.usecase.UserUseCase;
import co.barcochrist.todoapp.domain.usecase.impl.UserUseCaseImpl;
import co.barcochrist.todoapp.helpers.Callback;

/**
 * Created by christianbarco on 30/11/17.
 */

public class SignUpPresenter implements SignUpContract.UserActionsListener{

    private SignUpContract.View view;
    private UserUseCase userUseCase;

    public SignUpPresenter(SignUpContract.View view) {
        this.view = view;
        this.userUseCase = new UserUseCaseImpl();
    }

    @Override
    public void onSignUp(String fullName, String email, String password) {
        userUseCase.signUp(fullName, email, password, new Callback<User>() {
            @Override
            public void success(User result) {
                view.goToMainActivity();
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });
    }
}
