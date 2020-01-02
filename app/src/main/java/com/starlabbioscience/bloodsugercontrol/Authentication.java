package com.starlabbioscience.bloodsugercontrol;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * @AUTHOR : JOHN MELODY ME || HAFIZAN ||
 * @COPYRIGHT : BRAINTECH SDN BHD || STARLABS BIOSCIENCE SDN BHD
 * @PROJECT: BLOOD SUGAR CONTROL
 */
public class Authentication extends AppCompatActivity {
    EditText EMAIL, PASSWORD;
    Button LoginButton;

    private void INIT(){
        EMAIL = findViewById(R.id.email_edit_text);
        PASSWORD = findViewById(R.id.password_edit_test);
        LoginButton = findViewById(R.id.loginButton);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        INIT();

        // Login Button Config:
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email, Password;
                Email = EMAIL
                        .getText()
                        .toString();
                Password = PASSWORD
                        .getText()
                        .toString();

                if (TextUtils.isEmpty(Email)){
                    String msg;
                    msg = "PLEASE ENTER YOUR EMAIL";
                    EMAIL.setError(msg);
                } else{
                    System.out.println("$USER EMAIL ENTERED");
                }

                if (TextUtils.isEmpty(Password)){
                    String msg;
                    msg = "PLEASE ENTER YOUR PASSWORD";
                    PASSWORD.setError(msg);
                } else {
                    System.out.println("$USER PASSWORD ENTERED");
                }

                if (Password.length() <= 6 ){
                    String msg;
                    msg = "PLEASE ENTER A STRONG PASSWORD (MUST BE AT LEAST 6 LETTERS OR NUMBERS) ";
                    PASSWORD.setError(msg);
                } else {
                    System.out.println("$USER PASSWORD IS STRONG");
                }
            }
        });
    }
}