package com.example.yasinkhan.mealexplorer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    private Button signInnBtn;
    private EditText userNameEt, passwordEt;
    private String userName, passWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signInnBtn = findViewById(R.id.signInnBtn);
        userName = "yasin";
        passWord = "1234";

        signInnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userNameEt = findViewById(R.id.userNameEt);
                passwordEt = findViewById(R.id.passwordEt);
                if(userNameEt.getText().toString().equals(userName)&&passwordEt.getText().toString().equals(passWord)){
                    Intent i = new Intent(SignInActivity.this, FunctionalActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(SignInActivity.this, "Please, Enter a valid username & password !!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
