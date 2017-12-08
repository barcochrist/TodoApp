package co.barcochrist.todoapp.presentation.presenter;

/**
 * Created by christianbarco on 30/11/17.
 */

public interface LoginContract {

    /**
     * Interfaz que implementará el Fragment o Activity
     */
    interface View {
        void goToSignUpFragment();

        void goToMainActivity();

        void showMessageError(Exception error);

        void showProgress();

        void hideProgress();
    }

    /**
     * Interfaz que implementará el Presenter
     */
    interface UserActionsListeners {
        void onLogin(String email, String password, boolean remember);
    }
}
