package com.nayan.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     ListView timesTablesListView;

    public void generateFunction(int timesTableNumber){

        ArrayList<String> timesTableContents = new ArrayList<String>();

        for (int j = 1; j <= 10;j++){

            timesTableContents.add(Integer.toString(j* timesTableNumber));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContents);

        timesTablesListView.setAdapter(arrayAdapter);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timesTablesListView = findViewById(R.id.timesTablesListView);

        final SeekBar timesTablesSeekBar = findViewById(R.id.timesTablesSeekBar);

        timesTablesSeekBar.setMax(10);
        timesTablesSeekBar.setProgress(20);

        timesTablesSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = progress;
                int timesTableNumber;

                if(progress<min){
                    timesTableNumber = min;
                    timesTablesSeekBar.setProgress(min);
                }else {
                    timesTableNumber = progress;
                }

                generateFunction(timesTableNumber);
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
