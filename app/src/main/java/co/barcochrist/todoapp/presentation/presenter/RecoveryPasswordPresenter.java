package co.barcochrist.todoapp.presentation.presenter;

import co.barcochrist.todoapp.domain.usecase.UserUseCase;
import co.barcochrist.todoapp.domain.usecase.impl.UserUseCaseImpl;
import co.barcochrist.todoapp.helpers.Callback;

/**
 * Created by christianbarco on 5/12/17.
 */

public class RecoveryPasswordPresenter implements RecoveryPasswordContract.UserActionsListener {

    private RecoveryPasswordContract.View view;
    private UserUseCase userUseCase = new UserUseCaseImpl();

    public RecoveryPasswordPresenter(RecoveryPasswordContract.View view) {
        this.view = view;
    }

    @Override
    public void onRecovery(String email) {
        userUseCase.recoveryPassword(email, new Callback<Boolean>() {
            @Override
            public void success(Boolean result) {
                view.showSuccessMessage();
            }

            @Override
            public void error(Exception error) {
                view.showErrorMessage(error);
            }
        });
    }
}
