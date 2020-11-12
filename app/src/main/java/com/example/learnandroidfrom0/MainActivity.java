package com.example.learnandroidfrom0;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    Button btnChangeOmg;
    ImageView imageView;
    String nameFile;
    ConstraintLayout layoutmain;
    ImageButton btnImg_change;
    Switch switch_setBgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChangeOmg = findViewById(R.id.btnChangeImg);
        imageView = findViewById(R.id.imageView);
        imageView.setTag("zoro2");
        btnImg_change = findViewById(R.id.btnImg_change);
        switch_setBgr = findViewById(R.id.switch_setBgr);

        layoutmain = findViewById(R.id.layout_main);

        layoutmain.setBackgroundResource(R.drawable.background);

        btnChangeOmg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameFile = imageView.getTag().toString();
                if(nameFile.equals("zoro2")){
                    imageView.setImageResource(R.drawable.zoro);
                    imageView.setTag("zoro");
                }
                else{
                    imageView.setTag("zoro2");
                    imageView.setImageResource(R.drawable.zoro2);
                }
            }
        });

        btnImg_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameFile = imageView.getTag().toString();
                if(nameFile.equals("zoro2")){
                    imageView.setImageResource(R.drawable.zoro);
                    imageView.setTag("zoro");
                }
                else{
                    imageView.setTag("zoro2");
                    imageView.setImageResource(R.drawable.zoro2);
                }
            }
        });

        switch_setBgr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    layoutmain.setBackgroundResource(R.drawable.background);
                } else {
                    layoutmain.setBackgroundResource(0);
                }
            }
        });
    }
}