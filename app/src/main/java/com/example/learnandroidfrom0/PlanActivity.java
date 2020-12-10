package com.example.learnandroidfrom0;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;

public class PlanActivity extends AppCompatActivity implements
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
        if (direction == SimpleGestureFilter.SWIPE_RIGHT){
            Intent intent = new Intent(PlanActivity.this, EventActivity.class);
            startActivity(intent);
        }
    }


    //Toast shown when double tapped on screen
    @Override
    public void onDoubleTap() {

    }
}