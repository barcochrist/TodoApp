package co.barcochrist.todoapp.presentation.presenter;

/**
 * Created by christianbarco on 30/11/17.
 */

public interface SignUpContract {

    /**
     * Interfaz que implementará el Fragment o Activity.
     */
    interface View{
        void goToLoginFragment();

        void goToMainActivity();

        void showMessageError(Exception error);
    }

    /**
     * Interfaz que implementará el Presenter.
     */
    interface UserActionsListener{
        void onSignUp(String fullName, String email, String password);
    }
}
