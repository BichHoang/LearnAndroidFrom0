package com.example.learnandroidfrom0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CongViec().execute();
            }
        });
    }

    private class CongViec extends AsyncTask<Void, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Begin.\n");
        }

        @Override
        protected String doInBackground(Void... voids) {
            for (int i = 0; i < 5; i++) {
                publishProgress("Done: " + i + "\n");
            }
            return "Done\n";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.append(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            textView.append(values[0]);
        }
    }
}