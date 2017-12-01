package co.barcochrist.todoapp.presentation.presenter;

/**
 * Created by christianbarco on 30/11/17.
 */

public class AuthPresenter implements AuthContract.UserActionsListeners{

    private AuthContract.View view;

    public AuthPresenter(AuthContract.View view) {
        this.view = view;
    }

    @Override
    public void goToFirsFragment() {
        view.goToLoginFragment();
    }
}
