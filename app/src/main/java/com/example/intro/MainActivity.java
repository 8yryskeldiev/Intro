package com.example.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if (!isShown()) {
            startActivity( new Intent( MainActivity.this, IntroActivity.class ) );
            finish();
            return;
        }
        setContentView( R.layout.activity_main );


    }

    private boolean isShown() {
        SaveQuestions sv = new SaveQuestions(this);
     return  sv.isShown();
    }


}
