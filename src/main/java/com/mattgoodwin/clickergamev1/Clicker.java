package com.mattgoodwin.clickergamev1;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class Clicker {
    private int clickValue;
    private int money;
    private int netWorth;
    private int upgrade1cost;
    private int helpCost;
    private int help;
    private DecimalFormat CASH = new DecimalFormat("$###,###,###,##0");


    public Clicker( Context context ) {
        setMoney(0);
        setClickValue(1);
        setHelp(0);
        setNetWorth(0);
        setHelpCost(50);
        setUpgrade1Cost(10);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(  context );
        //setClickValue( pref.getInt( "clickerValue", 1 ) );
        //setMoney( pref.getInt( "money", 0 ) );
        //setNetWorth( pref.getInt("netWorth", 0));
    }


    public void setPreferences( Context context ) {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(  context );
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt( "clickerValue", clickValue );
        editor.putInt( "money", money);
        editor.putInt( "netWorth", netWorth );

        Log.w( "MA", "money is " + money );
        Log.w( "MA", "cv is " + clickValue );

        editor.commit();
    }

    public void setClickValue( int newClickValue ) {
        clickValue = newClickValue;
    }

    public void setMoney( int newMoney ) {
        money = newMoney;
    }

    public int getMoney(){
        return money;
    }

    public void setHelp(int newHelp){
        help = newHelp;
    }

    public void setNetWorth( int newNetWorth ) {
        netWorth = newNetWorth;
    }

    public void setMoneyLable(TextView view){
        view.setText(moneyString());
    }

    public void setHelpCost(int newCost){
        helpCost = newCost;
    }

    public void setUpgrade1Cost(int newCost){
        upgrade1cost = newCost;
    }


    public String moneyString(){
        return "Money: " + CASH.format(money);
    }







    public void click(TextView view){
        //String mString = view.getText().toString();
        //Log.w( "MA", "mString is " + mString );
        //int moniesInt = Integer.parseInt(mString);
        //Log.w( "MA", "monies is " + moniesInt );
        //moniesInt += clickValue;
        money += clickValue;
        //Log.w( "MA", "money = " + money );
        //mString = String.valueOf(money);
        //Log.w( "MA", "mString+1 is " + mString );
        //view.setText(mString);
        view.setText(moneyString());
    }

    public void upgrade1(TextView view){
        if ( money >= upgrade1cost){
            money -= upgrade1cost;
            clickValue++;
            view.setText(moneyString());
        }
    }

    public void firstHelp(TextView view){
        if ( money >= 50){
            money -= 50;
            help++;
            view.setText(moneyString());
        }
    }

    public void addHelp(TextView view){
        money += help;
        view.setText(moneyString());
    }

}
