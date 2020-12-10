package com.example.learnandroidfrom0;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        // Detect touched area
        detector = new SimpleGestureFilter(MainActivity.this, this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent me) {
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }

    @Override
    public void onSwipe(int direction) {
        switch (direction) {
            case SimpleGestureFilter.SWIPE_RIGHT:
                Intent intent = new Intent(MainActivity.this, DiaryActivity.class);
                startActivity(intent);
                break;
            case SimpleGestureFilter.SWIPE_LEFT:
                Intent intent1 = new Intent(MainActivity.this, EventActivity.class);
                startActivity(intent1);
                break;
        }
    }


    //Toast shown when double tapped on screen
    @Override
    public void onDoubleTap() {

    }

}