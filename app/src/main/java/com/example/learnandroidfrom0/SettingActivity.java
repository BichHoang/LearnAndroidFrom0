package com.example.learnandroidfrom0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class SettingActivity extends AppCompatActivity implements
        SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent me) {
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }

    @Override
    public void onSwipe(int direction) {
        if (direction == SimpleGestureFilter.SWIPE_LEFT){
            Intent intent = new Intent(SettingActivity.this, DiaryActivity.class);
            startActivity(intent);
        }
    }


    //Toast shown when double tapped on screen
    @Override
    public void onDoubleTap() {

    }
}