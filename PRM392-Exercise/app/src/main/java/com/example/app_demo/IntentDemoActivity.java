package com.example.app_demo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IntentDemoActivity extends AppCompatActivity {
    public TextView editTextName;
    public Button btnClickMe;
    public Button btnDial;
    public EditText editTextURL;
    public Button btnURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_demo);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextName = findViewById(R.id.editTextName);
        btnClickMe = findViewById(R.id.buttonClickMe);
        btnDial = findViewById(R.id.buttonDial);
        editTextURL = findViewById(R.id.editTextURL);
        btnURL = findViewById(R.id.buttonURL);

        //Explicit Intent
        //Input Your name, click button CLICK ME -> open MainActivity2, display Hello + name
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentDemoActivity.this, IntentDemo2Activity.class);
                String yName= editTextName.getText().toString();
                intent.putExtra("MESSAGE", yName);
                startActivity(intent);
            }
        });

        //Implicit Intent
        //Click button DIAL, open Dial UI
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });

        //Implicit Intent
        //Input URL, click button BROWSE URL -> open website
        btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = editTextURL.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}
