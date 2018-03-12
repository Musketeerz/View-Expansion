package com.example.rajprabhakar.expansiontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.transitionseverywhere.*;

public class MainActivity extends AppCompatActivity {

    ViewGroup transitionsContainer;
    boolean expanded = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transitionsContainer = findViewById(R.id.transitions_container);
    }

    public void change(View view) {
        TransitionManager.beginDelayedTransition(transitionsContainer, new TransitionSet()
                .addTransition(new ChangeBounds()).addTransition(new ChangeImageTransform()));
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.height = expanded ? ViewGroup.LayoutParams.MATCH_PARENT : 300;
        params.width = expanded ? ViewGroup.LayoutParams.MATCH_PARENT : 300;
        view.setLayoutParams(params);
        expanded = !expanded;
    }
}
