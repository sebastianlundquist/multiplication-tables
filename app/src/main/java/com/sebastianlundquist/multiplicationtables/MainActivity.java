package com.sebastianlundquist.multiplicationtables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTablesListView;

    public void generateTimesTable(int currentNumber) {
        ArrayList<String> timesTableContent = new ArrayList<>();

        for (int j = 1; j <= 10; j++) {
            timesTableContent.add(j + " * " + currentNumber + " = " + (j * currentNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timesTablesListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar timesTablesSeekBar = findViewById(R.id.multiplierSeekBar);
        timesTablesListView = findViewById(R.id.multiplicationListView);

        int max = 20;
        int start = 10;

        timesTablesSeekBar.setMax(max);
        timesTablesSeekBar.setProgress(start);

        generateTimesTable(start);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int currentNumber;
                if (i < min) {
                    currentNumber = min;
                    timesTablesSeekBar.setProgress(min);
                }
                else {
                    currentNumber = i;
                }
                generateTimesTable(currentNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
