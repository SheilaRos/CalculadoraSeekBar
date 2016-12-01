package com.example.dam.myapplication141116;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, ColorView.OnColorChangedListener{
    private EditNumber editNumber1, editNumber2, editNumber3;
    private TextView resultText;
    private ColorView colorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNumber1 = (EditNumber) findViewById(R.id.editNumber1);
        editNumber2 = (EditNumber) findViewById(R.id.editNumber2);
        editNumber3 = (EditNumber) findViewById(R.id.editNumber3);
        resultText = (TextView) findViewById(R.id.resultText);

        editNumber1.setMin(0);
        editNumber1.setMax(255);
        editNumber2.setMin(0);
        editNumber2.setMax(255);
        editNumber3.setMin(0);
        editNumber3.setMax(255);
        colorChanged(colorView, Color.BLUE);

        //editNumber2.setValue(0);
        editNumber1.setOnSeekBarChangeListener(this);
        editNumber2.setOnSeekBarChangeListener(this);
        editNumber3.setOnSeekBarChangeListener(this);
        colorView = (ColorView) findViewById(R.id.colorView);
        colorView.setOnColorChangedListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int color = Color.rgb(editNumber1.getValue(), editNumber2.getValue(), editNumber3.getValue());
        resultText.setText("#"+String.format("%06X", color).substring(2,8));
        colorView.setColor(color);
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}

    @Override
    public void colorChanged(View view, int color) {
        int r = Color.red(color);
        int g = Color.green(color);
        int b = Color.blue(color);
        editNumber1.setValue(r);
        editNumber2.setValue(g);
        editNumber3.setValue(b);
        resultText.setText("#"+String.format("%06X", color).substring(2,8));
    }
}
