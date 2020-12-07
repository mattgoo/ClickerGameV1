package com.mattgoodwin.clickergamev1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button clicker;
    private TextView monies;
    private int moniesInt;
    private int clickValue;
    private String mString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clicker = findViewById(R.id.clicker);
        monies = findViewById(R.id.dollars);

        clickValue = 1;

        clicker.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                click();
            }
        });
    }


    public void click(){
        mString = monies.getText().toString();
        //Log.w( "MA", "mString is " + mString );
        moniesInt = Integer.parseInt(mString);
        //Log.w( "MA", "monies is " + moniesInt );
        moniesInt += clickValue;
        //Log.w( "MA", "monies+1 is " + moniesInt );
        mString = String.valueOf(moniesInt);
        //Log.w( "MA", "mString+1 is " + mString );
        monies.setText(mString);
    }
}