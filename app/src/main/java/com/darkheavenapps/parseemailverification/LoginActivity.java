package com.darkheavenapps.parseemailverification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText userLogin, userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userLogin = findViewById(R.id.edtUserLogin);
        userPass = findViewById(R.id.edtUserPass);
    }

    public void loginIsPressed(View loginBtnView) {
        ParseUser.logInInBackground(userLogin.getText().toString(), userPass.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    boolean emailVerified = user.getBoolean("emailVerified");
                    if (emailVerified) {
                        // Hooray! The user is logged in.
                        Toast.makeText(LoginActivity.this, "Welcome " + userLogin.getText().toString(), Toast.LENGTH_SHORT).show();
                    } else {
                        // User did not confirm the e-mail!!
                        Toast.makeText(LoginActivity.this, "Email Confirmation Pending!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Signup failed. Look at the ParseException to see what happened.
                    Toast.makeText(LoginActivity.this, "Sign up Failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}