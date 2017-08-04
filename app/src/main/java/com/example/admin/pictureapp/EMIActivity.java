//Robert Price
package com.example.admin.pictureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import static java.lang.Math.pow;

//todo add button to go to main menu
public class EMIActivity extends AppCompatActivity {

    SeekBar seekBar;
    EditText interRate, numIns, loan;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi);

        seekBar = (SeekBar) findViewById(R.id.seekbar);

        interRate = (EditText) findViewById(R.id.interRate);
        numIns = (EditText) findViewById(R.id.numIns);
        loan = (EditText) findViewById(R.id.loan);

        result = (TextView) findViewById(R.id.result);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                double foo = i;
                foo /= 100;
                interRate.setText(String.valueOf(foo));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

    }

    public void calculate(View view){
        //loan interRate numIns
        double P = Double.parseDouble(String.valueOf(loan.getText()));
        double I = Double.parseDouble(String.valueOf(interRate.getText()));
        double N = Double.parseDouble(String.valueOf(numIns.getText()));

        I = (I/12)/100;

        double EMI = (P*I*pow((1+I),N))/(pow((1+I),N)-1);

        result.setText(Double.toString(EMI));
    }

    /*EMI = [Loan Amount x Interest Rate per month x (1+I)^N]/[(1+I)^N-1]

    P =loan amount or Principal

    I = Interest rate per month
    [To calculate rate per month: if the interest rate per annum is 14%, the per month rate would be 14/(12 x 100)]

    N = the number of installments*/
}
