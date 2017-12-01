package co.barcochrist.todoapp.presentation.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.barcochrist.todoapp.R;
import co.barcochrist.todoapp.presentation.presenter.AuthContract;
import co.barcochrist.todoapp.presentation.presenter.AuthPresenter;
import co.barcochrist.todoapp.presentation.view.fragment.LoginFragment;

public class AuthActivity extends AppCompatActivity implements AuthContract.View{

    private AuthContract.UserActionsListeners mActionsListeners;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mActionsListeners = new AuthPresenter(this);
        mActionsListeners.goToFirsFragment();
    }

    /**
     * Modifica el fragment a visualizar.
     * @param fragment
     * @param addToBackStack
     */
    public void replaceFragment(Fragment fragment, boolean addToBackStack){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        if(addToBackStack){
            fragmentTransaction.addToBackStack(null);       //Es posible recuperar un fragmento en la pila con el nombre definido como parametro
        }
        fragmentTransaction.commit();
    }

    @Override
    public void goToLoginFragment() {
        replaceFragment(LoginFragment.getInstance(), true);
    }

    @Override
    public void goToSignupFragment() {

    }

    @Override
    public void goMainActivity() {

    }
}
