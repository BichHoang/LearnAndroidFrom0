package com.example.learnandroidfrom0;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
    boolean isOver, isWin = false;
    int count = 3;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapping();
        layout_main.setVisibility(LinearLayout.GONE);
        imageView_count.setVisibility(View.GONE);
        seekBar_bee.setEnabled(false);
        seekBar_bird.setEnabled(false);
        seekBar_elephant.setEnabled(false);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPlay.setVisibility(View.INVISIBLE);
                layout_main.setVisibility(LinearLayout.VISIBLE);
                setEnableCheckbox(true);
            }
        });

        checkBox_bee.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox_bird.setChecked(false);
                    checkBox_elephant.setChecked(false);
                    setEnableCheckbox(false);
                    imageViewCount(1);
                }
            }
        });

        checkBox_bird.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox_bee.setChecked(false);
                    checkBox_elephant.setChecked(false);
                    setEnableCheckbox(false);
                    imageViewCount(2);
                }
            }
        });

        checkBox_elephant.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkBox_bee.setChecked(false);
                    checkBox_bird.setChecked(false);
                    setEnableCheckbox(false);
                    imageViewCount(3);
                }
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

    public void play(final int choise){
        CountDownTimer countDownTimer = new CountDownTimer(150, 150) {
            @Override
            public void onTick(long millisUntilFinished) {
                Random random = new Random();
                int max_race = seekBar_bee.getMax();
                if (seekBar_bee.getProgress() >= max_race){
                    isOver = true;
                    if (choise == 1){
                        isWin = true;
                    }
                    message = "Bee";
                }
                if (seekBar_bird.getProgress() >= max_race){
                    isOver = true;
                    if (choise == 2){
                        isWin = true;
                    }
                    message = "Bird";
                }
                if (seekBar_elephant.getProgress() >= max_race){
                    isOver = true;
                    if (choise == 3){
                        isWin = true;
                    }
                    message = "Elephant";
                }

                seekBar_bee.setProgress(seekBar_bee.getProgress() + random.nextInt(50));
                seekBar_bird.setProgress(seekBar_bird.getProgress() +random.nextInt(50));
                seekBar_elephant.setProgress(seekBar_elephant.getProgress() + random.nextInt(50));
            }

            @Override
            public void onFinish() {
                if(!isOver){
                    this.start();
                }else{
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    if(isWin){
                        alertDialog.setTitle("You Won");
                    }else{
                        alertDialog.setTitle("Game Over");
                    }

                    alertDialog.setMessage(message + " is the winner");
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    btnPlay.setVisibility(View.VISIBLE);
                                    reset();
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        }.start();
    }

    public void imageViewCount(final int choise){
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
                play(choise);
            }
        }.start();
    }

    public  void reset(){
        seekBar_bee.setProgress(5);
        seekBar_bird.setProgress(5);
        seekBar_elephant.setProgress(5);
        checkBox_bee.setChecked(false);
        checkBox_bird.setChecked(false);
        checkBox_elephant.setChecked(false);
        isOver = false;
        isWin = false;
        count = 3;
        imageView_count.setVisibility(View.INVISIBLE);
        setEnableCheckbox(false);
    }

    public void setEnableCheckbox(boolean setCheck){
        checkBox_elephant.setEnabled(setCheck);
        checkBox_bird.setEnabled(setCheck);
        checkBox_bee.setEnabled(setCheck);
    }
}