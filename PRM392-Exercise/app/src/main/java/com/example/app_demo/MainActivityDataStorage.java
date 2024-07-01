package com.example.app_demo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.SharedPreferences;
import android.content.Context;
import android.view.View;
public class MainActivityDataStorage  extends AppCompatActivity {
    EditText editTextName;
    EditText editTextEmail;
    Button buttonSave;
    Button buttonLoad;
    private TextView textViewResult;
    private static final String SHARED_PREFS = "sharedPrefs";
    private static final String NAME_KEY = "name";
    private static final String EMAIL_KEY = "email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_data_storage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSave = findViewById(R.id.buttonSave1);
        buttonLoad = findViewById(R.id.buttonLoad1);
        textViewResult = findViewById(R.id.textViewResult1);
    }
    // Save name and email to Shared Preferences
    public void onSave(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME_KEY, editTextName.getText().toString());
        editor.putString(EMAIL_KEY, editTextEmail.getText().toString());
        editor.apply();
    }
    // Get name and email from Shared Preferences
    public void onLoad(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String name = sharedPreferences.getString(NAME_KEY, "");
        String email = sharedPreferences.getString(EMAIL_KEY, "");
        textViewResult.setText("Name: " + name + "\nEmail: " + email);
    }
}

