package co.barcochrist.todoapp.presentation.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import co.barcochrist.todoapp.R;
import co.barcochrist.todoapp.helpers.Utilities;
import co.barcochrist.todoapp.presentation.presenter.LoginContract;
import co.barcochrist.todoapp.presentation.presenter.LoginPresenter;
import co.barcochrist.todoapp.presentation.view.activity.AuthActivity;
import co.barcochrist.todoapp.presentation.view.activity.MainActivity;
import co.barcochrist.todoapp.presentation.view.dialog.RecoveryPasswordFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.View, View.OnClickListener {

    private LoginContract.UserActionsListeners mActionListener;

    /**
     * Se utiliza este componente para soportar más funcionalidades, como por ejemplo
     * mostrar errores al estilo Material Design. Con este componente se puede obtener el InputText.
     */
    private TextInputLayout tilEmail, tilPassword;
    private TextView tvForgotPassword;
    private Switch swRemember;
    private Button btnStart, btnNotHaveAccount;
    private ProgressBar pbProgress;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mActionListener = new LoginPresenter(this);

        //Obtiene una referencia de los componentes visuales del fragmento Login
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        tilEmail = view.findViewById(R.id.tilEmail);
        tilPassword = view.findViewById(R.id.tilPassword);
        tvForgotPassword = view.findViewById(R.id.tvForgotPassword);
        swRemember = view.findViewById(R.id.swRemember);
        btnStart = view.findViewById(R.id.btnStart);
        btnNotHaveAccount = view.findViewById(R.id.btnNotHaveAccount);
        pbProgress = view.findViewById(R.id.pbProgress);

        btnStart.setOnClickListener(this);
        btnNotHaveAccount.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                onLogin();
                break;
            case R.id.btnNotHaveAccount:
                goToSignUpFragment();
                break;
            case R.id.tvForgotPassword:
                goToRecoveryPassword();
                break;
        }
    }

    @Override
    public void goToSignUpFragment() {
        AuthActivity authActivity = (AuthActivity) getActivity();
        authActivity.replaceFragment(SignUpFragment.getInstance(), true);
    }

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }

    public void goToRecoveryPassword() {
        RecoveryPasswordFragment recoveryPasswordFragment = RecoveryPasswordFragment.getInstance();
        recoveryPasswordFragment.show(getFragmentManager(), null);
    }

    @Override
    public void showMessageError(Exception error) {
        Snackbar.make(getView(), error.getMessage(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showProgress() {
        pbProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbProgress.setVisibility(View.INVISIBLE);
    }

    private void onLogin() {
        try {
            boolean result = true;
            String email = tilEmail.getEditText().getText().toString();
            String password = tilPassword.getEditText().getText().toString();
            boolean remember = swRemember.isChecked();

            if (Utilities.isEmpty(email)) {
                tilEmail.setError(getString(R.string.is_required));
                tilEmail.setErrorEnabled(true);
                result = false;
            } else {
                tilEmail.setError(null);
                tilEmail.setErrorEnabled(false);
            }

            if (Utilities.isEmpty(password)) {
                tilPassword.setError(getString(R.string.is_required));
                tilPassword.setErrorEnabled(true);
                result = false;
            } else {
                tilPassword.setError(null);
                tilPassword.setErrorEnabled(false);
            }

            //Si la validaciones no generaron errores
            if (result) {
                mActionListener.onLogin(email, password, remember);
            }
        } catch (Exception e) {

        }
    }
}
