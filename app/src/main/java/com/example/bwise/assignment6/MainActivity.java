package com.example.bwise.assignment6;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener{

    // create instance variables
    private EditText editTextEntry;
    private TextView textViewValue;
    private TextView textViewPercent;
    private SeekBar seekBar;

    // define instance variables that should be saved
    private String billAmountString = "";
    private float billAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get references to widgets
        editTextEntry = (EditText) findViewById(R.id.editTextEntry);
        textViewValue = (TextView) findViewById(R.id.textViewValue);
        textViewPercent = (TextView) findViewById(R.id.textViewPercent);
        seekBar = (SeekBar) findViewById(R.id.seekBar);

        //set listener
        seekBar.setOnSeekBarChangeListener(this);

        textViewPercent.setText("Tip Percentage:    " + 18);
    }

    public void calculateAndDisplay(){

        // get the bill amount
        //billAmountString = editTextEntry.getText().toString();
        //billAmount = Float.parseFloat(billAmountString);

        billAmount = Float.parseFloat(editTextEntry.getText().toString());

        // calculate tip amount
        float tipPercent = seekBar.getProgress();
        float tipAmount = (billAmount * tipPercent) / 100;


        // display the other results with formatting
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        textViewValue.setText(currency.format(tipAmount));



    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        //Toast.makeText(getApplicationContext(), "Percentage: " + progress, Toast.LENGTH_SHORT).show();
        textViewPercent.setText("Tip Percentage:    " + progress);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(getApplicationContext(), "Tip Percentage Set", Toast.LENGTH_LONG).show();
        calculateAndDisplay();

    }
}
