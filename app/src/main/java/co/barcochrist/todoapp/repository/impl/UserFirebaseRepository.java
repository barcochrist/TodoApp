package co.barcochrist.todoapp.repository.impl;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import co.barcochrist.todoapp.domain.model.User;
import co.barcochrist.todoapp.helpers.Callback;
import co.barcochrist.todoapp.repository.UserRepository;

/**
 * Created by christianbarco on 30/11/17.
 */

public class UserFirebaseRepository implements UserRepository {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public UserFirebaseRepository() {
        this.mAuth = FirebaseAuth.getInstance();
        this.mDatabase = FirebaseDatabase.getInstance()
                .getReference("users");
    }

    @Override
    public void login(String email, String password, Callback<User> callback) {

    }

    @Override
    public void signUp(User user, Callback<User> callback) {

    }

    @Override
    public void recoveryPassword(String email, Callback<Boolean> callback) {

    }
}
