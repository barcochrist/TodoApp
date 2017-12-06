package co.barcochrist.todoapp.presentation.presenter;

/**
 * Created by christianbarco on 5/12/17.
 */

public interface RecoveryPasswordContract {
    interface View {
        void showErrorMessage(Exception error);

        void showSuccessMessage();
    }

    interface UserActionsListener {
        void onRecovery(String email);
    }
}
