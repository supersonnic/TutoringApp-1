package com.example.roji.tutoring_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TutorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);

        final TextView msgTutor = (TextView) findViewById(R.id.tvTutorMsg);

        String msg = "Tutor view";
        msgTutor.setText(msg);
    }
}
