package com.example.learnandroidfrom0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Switch aSwitch;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    CountDownTimer countDownTimer = new CountDownTimer(300, 300) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            if(progressBar.getProgress() >= progressBar.getMax()){
                                progressBar.setProgress(0);
                            }
                            progressBar.setProgress(progressBar.getProgress() + 5);
                        }

                        @Override
                        public void onFinish() {
                            this.start();
                        }
                    };
                    countDownTimer.start();
                }else{
                    progressBar.setProgress(0);
                }
            }
        });
    }

    public void mapping(){
        aSwitch = findViewById(R.id.switch1);
        progressBar = findViewById(R.id.progressBar);
    }
}