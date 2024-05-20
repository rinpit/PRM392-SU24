package com.example.app_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
//    view
    public Button myButton;
    public EditText myUser;
    public EditText myPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        Connect Views in Java file and XML file by id
        myButton = findViewById(R.id.loginbtn);
        myUser = findViewById(R.id.username);
        myPass = findViewById(R.id.password);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myUser.getText().toString().equals("admin") && myPass.getText().toString().equals("12345")){
                    Toast.makeText(getApplicationContext(),"Login Successfull", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Login failed",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
//          Handling action for button
//    public void onLogin(View view){
//        if (myUser.getText().toString().equals("admin") && myPass.getText().toString().equals("12345")){
//            Toast.makeText(getApplicationContext(),"Login Successfull", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(getApplicationContext(),"Login failed",Toast.LENGTH_SHORT).show();
//        }
//    }
}




