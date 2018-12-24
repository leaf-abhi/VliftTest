package com.example.toni.vlifttest.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.toni.vlifttest.R;
import com.example.toni.vlifttest.SessionManager;
import com.example.toni.vlifttest.database.Database;
import com.example.toni.vlifttest.fragment.login.LoginFragment;
import com.example.toni.vlifttest.fragment.login.LoginPromoFragment;
import com.example.toni.vlifttest.model.User;

public class LoginActivity extends AppCompatActivity implements
        LoginPromoFragment.FragmentInteractionListener,
        LoginFragment.FragmentInteractionListener{
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SessionManager.init(this);
        frameLayout = findViewById(R.id.frame_layout_login_activity);
        getSupportFragmentManager().beginTransaction()
                .replace(frameLayout.getId(),LoginPromoFragment.newInstance())
                .commit();
    }

    @Override
    public void onClickLoginPromo() {
        getSupportFragmentManager().beginTransaction()
                .replace(frameLayout.getId(),LoginFragment.newInstance())
                .commit();
    }

    @Override
    public void onClickLogin(String email, String password) {
        User user = Database.getInstance().getUser(email);
        if(password.equals(user.getPassword())) {
            SessionManager.getInstance().createSession(user);
            Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,MainActivity.class));
            this.finish();
        } else {
            Toast.makeText(this,"Incorrect Login Details",Toast.LENGTH_LONG).show();
        }
    }
}
