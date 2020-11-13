package com.example.learnandroidfrom0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar_bee, seekBar_bird, seekBar_elephant;
    CheckBox checkBox_bee, checkBox_bird, checkBox_elephant;
    ImageButton btnPlay;
    LinearLayout layout_main;
    ImageView imageView_count;
    boolean isOver = false;
    int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        layout_main.setVisibility(LinearLayout.GONE);
        imageView_count.setVisibility(View.GONE);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout_main.setVisibility(LinearLayout.VISIBLE);
                btnPlay.setVisibility(View.GONE);
            }
        });

        checkBox_bee.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox_bird.setChecked(false);
                    checkBox_elephant.setChecked(false);
                }
                imageViewCount();
            }
        });

        checkBox_bird.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox_bee.setChecked(false);
                    checkBox_elephant.setChecked(false);
                }
                imageViewCount();
            }
        });

        checkBox_elephant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox_bee.setChecked(false);
                    checkBox_bird.setChecked(false);
                }
                imageViewCount();
            }
        });
    }

    public void mapping(){
        seekBar_bee = findViewById(R.id.seekBar_bee);
        seekBar_bird = findViewById(R.id.seekBar_bird);
        seekBar_elephant = findViewById(R.id.seekBar_elephant);
        checkBox_bee = findViewById(R.id.checkbox_bee);
        checkBox_bird = findViewById(R.id.checkbox_bird);
        checkBox_elephant = findViewById(R.id.checkbox_elephant);
        btnPlay = findViewById(R.id.btnPlay);
        layout_main = findViewById(R.id.layout_main);
        imageView_count = findViewById(R.id.imageView_count);
    }

    public void play(){
        CountDownTimer countDownTimer = new CountDownTimer(300, 300) {
            @Override
            public void onTick(long millisUntilFinished) {
                Random random = new Random();
                int max_race = seekBar_bee.getMax();
                if((seekBar_bee.getProgress() >= max_race) || (seekBar_bird.getProgress() >= max_race) || seekBar_elephant.getProgress() >= max_race){
                    isOver = true;
                }
                seekBar_bee.setProgress(seekBar_bee.getProgress() + random.nextInt(20) + 1);
                seekBar_bird.setProgress(seekBar_bird.getProgress() +random.nextInt(20) + 1);
                seekBar_elephant.setProgress(seekBar_elephant.getProgress() + random.nextInt(20) + 1);
            }

            @Override
            public void onFinish() {
                if(!isOver){
                    this.start();
                }else{
                    Toast.makeText(MainActivity.this, "Game over", Toast.LENGTH_SHORT).show();
                }
            }
        }.start();
    }

    public void imageViewCount(){
        imageView_count.setVisibility(View.VISIBLE);

        CountDownTimer countDownTimer = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                switch (count){
                    case 0:
                        imageView_count.setImageResource(R.drawable.go);
                        break;
                    case 1:
                        imageView_count.setImageResource(R.drawable.one);
                        break;
                    case 2:
                        imageView_count.setImageResource(R.drawable.two);
                        break;
                    case 3:
                        imageView_count.setImageResource(R.drawable.three);
                        break;
                }
                imageView_count.setBackgroundResource(R.drawable.two);
                count = count - 1;
            }

            @Override
            public void onFinish() {
                imageView_count.setImageResource(R.drawable.three);
                imageView_count.setVisibility(View.INVISIBLE);
                play();
            }
        }.start();
    }
}