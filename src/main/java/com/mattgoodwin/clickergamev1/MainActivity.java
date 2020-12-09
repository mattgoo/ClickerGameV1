package com.mattgoodwin.clickergamev1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button clickButton;
    private TextView monies;
    private Clicker clicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clickButton = findViewById(R.id.clicker);
        monies = findViewById(R.id.dollars);

        clicker = new Clicker( this );

        clickButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clicker.updateMonies(monies);
            }
        });
    }


    @Override
    public void onDestroy(){
        super.onDestroy();

    }
}