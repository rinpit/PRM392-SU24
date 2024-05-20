package com.example.app_demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity {
    public EditText num1;
    public EditText num2;
    public Button btnAdd;
    public Button btnSub;
    public Button btnMul;
    public Button btnDiv;

    public TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_caculator_app);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calculatorapp), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        result = findViewById(R.id.textViewResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });



    }

    private void calculate(char operator) {
        String num1Str = num1.getText().toString();
        String num2Str = num2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            result.setText("Enter both numbers");
            return;
        }

        double number1 = Double.parseDouble(num1Str);
        double number2 = Double.parseDouble(num2Str);
        double resultValue = 0;

        switch (operator) {
            case '+':
                resultValue = number1 + number2;
                break;
            case '-':
                resultValue = number1 - number2;
                break;
            case '*':
                resultValue = number1 * number2;
                break;
            case '/':
                if (number2 != 0) {
                    resultValue = number1 / number2;
                } else {
                    result.setText("Cannot divide by zero");
                    return;
                }
                break;
        }
        result.setText("Result: " + resultValue);
    }

}
