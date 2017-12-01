package co.barcochrist.todoapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import co.barcochrist.todoapp.R;
import co.barcochrist.todoapp.helpers.Utilities;
import co.barcochrist.todoapp.presentation.presenter.LoginContract;
import co.barcochrist.todoapp.presentation.presenter.LoginPresenter;
import co.barcochrist.todoapp.presentation.view.activity.AuthActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.View{

    private LoginContract.UserActionsListeners mActionListener;
    /**
     * Se utiliza este componente para soportar más funcionalidades, como por ejemplo
     * mostrar errores al estilo Material Design. Con este componente se puede obtener el InputText.
     */
    private TextInputLayout tilEmail, tilPassword;
    private TextView tvForgotPassword;
    private Switch swRemember;
    private Button btnStart, btnNotHaveAccount;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment getInstance(){
        return new LoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mActionListener = new LoginPresenter(this);
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        tilEmail = (TextInputLayout) view.findViewById(R.id.tilEmail);
        tilPassword = (TextInputLayout) view.findViewById(R.id.tilPassword);
        tvForgotPassword = (TextView) view.findViewById(R.id.tvForgotPassword);
        swRemember = (Switch) view.findViewById(R.id.swRemember);
        btnStart = (Button) view.findViewById(R.id.btnStart);
        btnNotHaveAccount = (Button) view.findViewById(R.id.btnNotHaveAccount);
        return view;
    }

    @Override
    public void goToSignUpFragment() {
        AuthActivity authActivity = (AuthActivity) getActivity();
        authActivity.replaceFragment(SignUpFragment.getInstance(), false);
    }

    @Override
    public void goToMainActivity() {

    }

    private void onLogin(){
        try {
            boolean result = true;
            String email = tilEmail.getEditText().getText().toString();
            String password = tilPassword.getEditText().getText().toString();
            boolean remember = swRemember.isChecked();

            if(Utilities.isEmpty(email)){
                tilEmail.setError(getString(R.string.is_required));
                tilEmail.setErrorEnabled(true);
                result = false;
            }else{
                tilEmail.setError(null);
                tilEmail.setErrorEnabled(false);
            }

            if(Utilities.isEmpty(password)){
                tilPassword.setError(getString(R.string.is_required));
                tilPassword.setErrorEnabled(true);
                result = false;
            }else{
                tilPassword.setError(null);
                tilPassword.setErrorEnabled(false);
            }

            if(result){
                mActionListener.onLogin(email, password,remember);
            }
        }catch (Exception e){

        }
    }
}
