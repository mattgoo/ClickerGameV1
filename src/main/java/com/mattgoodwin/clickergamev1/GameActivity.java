package com.mattgoodwin.clickergamev1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Timer;

public class GameActivity extends AppCompatActivity {
    private Button helpButton;
    private Button upgrade1button;
    private Button clickButton;
    private TextView monies;
    private Clicker clicker;
    private Handler handler = new Handler();
    private Runnable runnableCode;
    private DecimalFormat CASH = new DecimalFormat("$###,###,###,##0");

    private TextView clickValue;
    private TextView helpers;
    private TextView doublePoints;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        clickButton = findViewById(R.id.clicker);
        monies = findViewById(R.id.dollars);
        upgrade1button = findViewById(R.id.upgrade1);
        helpButton = findViewById(R.id.getHelp);
        clickValue = findViewById(R.id.clickValue);
        helpers = findViewById(R.id.helpers);
        doublePoints = findViewById(R.id.doublePoints);


        clicker = new Clicker( this );


        clickButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clicker.click(monies);
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicker.firstHelp(monies, helpers);
            }
        });

        upgrade1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicker.upgrade1(monies, clickValue);
            }
        });

        doublePoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });


        // Define the code block to be executed
        handler = new Handler();
        runnableCode = new Runnable() {
            @Override
            public void run() {
                // Do something here on the main thread
                clicker.addHelp(monies);
                Log.w("Handlers", "Called on main thread");
                // Repeat this the same runnable code block again another 2 seconds
                handler.postDelayed(runnableCode, 500);
            }
        };
        // Start the initial runnable task by posting through the handler
        handler.post(runnableCode);

    }

    /*
    public void helpUpdate(){
        clicker.addHelp();
        clicker.setMoneyLable(monies);
    }

     */

    @Override
    protected void onResume( ) {
        super.onResume( );
        Log.w( "MA", "Inside MainActivity::onResume" );
        //clicker.updateMonies(monies);
    }

    @Override
    protected void onStart( ) {
        super.onStart( );
        Log.w( "MA", "Inside MainActivity::onStart" );
        clicker.setMoneyLable(monies);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        clicker.setPreferences( this );
        Log.w("MA", "destroyed");
    }
}