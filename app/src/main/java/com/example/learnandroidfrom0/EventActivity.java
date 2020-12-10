package com.example.learnandroidfrom0;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

public class EventActivity extends AppCompatActivity implements
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
        switch (direction) {
            case SimpleGestureFilter.SWIPE_RIGHT:
                Intent intent = new Intent(EventActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case SimpleGestureFilter.SWIPE_LEFT:
                Intent intent1 = new Intent(EventActivity.this, PlanActivity.class);
                startActivity(intent1);
                break;
        }
    }


    //Toast shown when double tapped on screen
    @Override
    public void onDoubleTap() {

    }
}