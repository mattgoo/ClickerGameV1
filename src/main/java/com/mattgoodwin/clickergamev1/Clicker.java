package com.mattgoodwin.clickergamev1;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class Clicker {
    private int clickValue;
    private int money;
    private int netWorth;


    public Clicker( ) {
        setClickValue( 1 );
        setMoney( 0 );
        setNetWorth( 0 );
    }

    // Read from user preferences
    public Clicker( Context context ) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(  context );
        setClickValue( pref.getInt( "clickerValue", 1 ) );
        setMoney( pref.getInt( "money", 0 ) );
        setNetWorth( pref.getInt("netWorth", 0));
    }

    // method to write the data inside *this* Mortgage object to preferences
    public void setPreferences( Context context ) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(  context );
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt( "clickerValue", clickValue );
        editor.putInt( "money", money);
        editor.putInt( "netWorth", netWorth );
        editor.commit();
    }

    public void setClickValue( int newClickValue ) {
        if( newClickValue >= 0 )
            clickValue = newClickValue;
    }

    public void setMoney( int newMoney ) {
        if( newMoney >= 0 )
            money = newMoney;
    }

    public void setNetWorth( int newNetWorth ) {
        if( newNetWorth >= 0 )
            netWorth = newNetWorth;
    }

    public void updateMonies(TextView view){
        String mString = view.getText().toString();
        //Log.w( "MA", "mString is " + mString );
        int moniesInt = Integer.parseInt(mString);
        //Log.w( "MA", "monies is " + moniesInt );
        moniesInt += clickValue;
        //Log.w( "MA", "monies+1 is " + moniesInt );
        mString = String.valueOf(moniesInt);
        //Log.w( "MA", "mString+1 is " + mString );
        view.setText(mString);
    }

}
