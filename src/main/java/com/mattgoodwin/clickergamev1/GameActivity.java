package com.mattgoodwin.clickergamev1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
    private TextView income;

    AlertDialog.Builder alert;



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
        income = findViewById(R.id.dollarPerSec);


        alert = new AlertDialog.Builder(this);
        alert.setTitle("Ad?");
        alert.setMessage("Do you want to see an ad for double click value and double help?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });


        clicker = new Clicker( this );
        clicker. updateViews(clickValue, helpers, income);

        clickButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clicker.click(monies);
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicker.firstHelp(monies, helpers, income);
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
                clicker.doubleRewards(clickValue, helpers);
            }
        });


        // Define the code block to be executed
        handler = new Handler();
        runnableCode = new Runnable() {
            @Override
            public void run() {
                clicker.addHelp(monies);
                Log.w("MA", "run");
                handler.postDelayed(runnableCode, 500);
            }
        };
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