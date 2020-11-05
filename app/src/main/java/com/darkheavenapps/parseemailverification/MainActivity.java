package com.darkheavenapps.parseemailverification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/*
    Process of setting up parse server using back4app
    setup details can be found on back4app Introduction section.
    signing up and login code can also be found there..
 */

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText, usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ParseInstallation.getCurrentInstallation().saveInBackground();  //code to verify installation on a phone
        emailEditText = findViewById(R.id.editTextEmail);
        usernameEditText = findViewById(R.id.editTextUsername);
        passwordEditText = findViewById(R.id.editTextPassword);
    }

    public void signUpIsPressed(View btnView) {
        //Toast.makeText(this, "Sign up is pressed!", Toast.LENGTH_SHORT).show();

        ParseUser user = new ParseUser();
        user.setUsername(usernameEditText.getText().toString());
        user.setPassword(passwordEditText.getText().toString());
        user.setEmail(emailEditText.getText().toString());

        // Other fields can be set just like any other ParseObject,
        // using the "put" method, like this: user.put("attribute", "its value");
        // If this field does not exists, it will be automatically created

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                    ParseUser.logOut();
                    Toast.makeText(MainActivity.this, "Sign up Succeeded!, Kindly verify email", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    MainActivity.this.startActivity(intent);
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                    ParseUser.logOut();
                    Toast.makeText(MainActivity.this, "Sign up Unsuccessful!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}