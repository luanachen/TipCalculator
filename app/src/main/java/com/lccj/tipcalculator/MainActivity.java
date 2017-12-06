package com.lccj.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  private TextView billAmount;
  private SeekBar seekBar;
  private TextView seekBarValue;
  private Button buttonCalculateTip;
  private TextView totalResultTextView;
  private int seekBarFinalPercentage;
  private float enteredAmountFloat;
  private TextView textTotalBill;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    billAmount = findViewById(R.id.textBillAmount);
    seekBar = findViewById(R.id.seekBar);
    seekBarValue = findViewById(R.id.seekBarValue);
    buttonCalculateTip = findViewById(R.id.btnCalculateTip);
    totalResultTextView = findViewById(R.id.txtResult);
    textTotalBill = findViewById(R.id.txtTotalBill);


    buttonCalculateTip.setOnClickListener(this);

    seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

      @Override
      public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {

        seekBarValue.setText(String.valueOf(seekBar.getProgress()) + "%");

      }

      @Override
      public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
      }

      @Override
      public void onStopTrackingTouch(SeekBar seekBar) {

        seekBarFinalPercentage = seekBar.getProgress();

      }

    });


  }
  @Override
  public void onClick(View v) {

    calculateTip();

  }

  public void calculateTip(){

    float result;

    if(!billAmount.getText().toString().equals("")){

      enteredAmountFloat = Float.parseFloat(billAmount.getText().toString());
      result = (enteredAmountFloat * seekBarFinalPercentage) / 100;
      totalResultTextView.setText("Your tip will be: $" + String.valueOf(result));
      textTotalBill.setText("$" +
          String.valueOf(result + enteredAmountFloat));

    }else {
      Toast.makeText(MainActivity.this,
          "Please enter a bill amount", Toast.LENGTH_LONG).show();
    }
  }
}
