package com.example.popupfragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private GestureDetector gestureDetector;
    private boolean popPressed;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        this.gestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button press = findViewById(R.id.presss);
        press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                press.setText("Works");
            }
        });

        GestureDetector.SimpleOnGestureListener gestureListener = new GestureDetector.SimpleOnGestureListener(){
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                final int SWIPE_MIN_DISTANCE = 120;
                final int SWIPE_MAX_OFF_PATH = 250;
                final int SWIPE_THRESHOLD_VELOCITY = 200;
                try {
                    if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                        return false;
                    if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
                            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                        Log.i("Tag", "Right to Left");
                        if(popPressed){
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.parent, new PopUp())
                                    .commit();
                        }
                    } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                        Log.i("Tag", "Left to Right");
                        if(popPressed){
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.parent, new PopUpTwo())
                                    .commit();
                        }

                    }
                } catch (Exception e) {
                    // nothing
                }
                return false;
            }

            @Override
            public boolean onDown(MotionEvent event) {
                return true;
            }
        };
        Button pop = findViewById(R.id.fragment);
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popPressed = true;
                press.setOnClickListener(null);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.parent, new PopUp())
                        .addToBackStack(null)
                        .commit();
            }
        });

        gestureDetector = new GestureDetector(this, gestureListener);




    }
}
