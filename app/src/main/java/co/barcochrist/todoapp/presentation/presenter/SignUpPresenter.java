package co.barcochrist.todoapp.presentation.presenter;

/**
 * Created by christianbarco on 30/11/17.
 */

public class SignUpPresenter implements SignUpContract.UserActionsListener{

    private SignUpContract.View view;

    public SignUpPresenter(SignUpContract.View view) {
        this.view = view;
    }

    @Override
    public void onSigup(String fullName, String email, String password) {

    }
}
