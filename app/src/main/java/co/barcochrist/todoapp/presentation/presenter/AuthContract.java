package co.barcochrist.todoapp.presentation.presenter;

/**
 * Created by christianbarco on 30/11/17.
 *
 */

public interface AuthContract {

    /**
     * Interfaz que implementará el Fragment o Activity
     */
    interface View {
        void goToLoginFragment();
        void goMainActivity();
    }

    /**
     * Interfaz que implementará el Presenter
     */
    interface UserActionsListeners{

        void goToFirsFragment();
    }
}
