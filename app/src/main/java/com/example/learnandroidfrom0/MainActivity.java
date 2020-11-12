package com.example.learnandroidfrom0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnClickMe, btnClearTxt, btnToast, btnRandomNumber;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        btnClickMe = findViewById(R.id.btn_ClickMe);
        btnClearTxt = findViewById(R.id.btn_ClearTxt);
        btnToast = findViewById(R.id.btn_Toast);
        editText = findViewById(R.id.editTxt);
        btnRandomNumber = findViewById(R.id.btn_RandomNumber);

        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Clicked!!!");
            }
        });

        btnClearTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
            }
        });
        
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(editText.getText().toString());
                Toast.makeText(MainActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btnRandomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int numberRandom = random.nextInt(10); // 0 - 9
                textView.setText("" + numberRandom);
            }
        });
    }
}