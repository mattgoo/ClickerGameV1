package com.mattgoodwin.clickergamev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button startButton;
    private Clicker clicker;
    private TextView wallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clicker = new Clicker(this);
        wallet = findViewById(R.id.walletLable);
        startButton = findViewById(R.id.button);

        clicker.walletString(wallet);

        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openGame(v);
            }
        });
    }

    public void openGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume(){
        super.onResume();
        clicker.walletString(wallet);
    }

}