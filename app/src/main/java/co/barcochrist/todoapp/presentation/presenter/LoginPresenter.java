package co.barcochrist.todoapp.presentation.presenter;

/**
 * Created by christianbarco on 30/11/17.
 */

public class LoginPresenter implements LoginContract.UserActionsListeners {

    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void onLogin(String email, String password, boolean remember) {

    }
}
