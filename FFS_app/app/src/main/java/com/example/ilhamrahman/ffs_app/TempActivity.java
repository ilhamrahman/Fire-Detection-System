package com.example.ilhamrahman.ffs_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        Intent temp = getIntent();
        boolean temp_button = temp.getBooleanExtra(MainActivity.TEMPERATURE, false);


        String message = temp.getStringExtra(MainActivity.EXTRA_MESSAGE);


        TextView tempValue = (TextView) findViewById(R.id.textView11);
        tempValue.setText(getTemp());

        // Capture the layout's TextView and set the string as its text
        TextView status = (TextView) findViewById(R.id.textView12);
        status.setText(tempMessage());


        //Set up for Home Button OnCLick
        Button homeButton = (Button) findViewById(R.id.homeButtonT);

        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent homeIntent = new Intent(TempActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });
    }
    public String tempMessage() {

        String TempLow = "RELAX! The current temperature is below the dangerous threshold temperature.";
        String TempHigh = "DANGER! The current temperature is above the dangerous threshold temperature.";

        double tempValue =  Double.parseDouble(MainActivity.temp);

        if (tempValue > 50){
            return TempHigh;
        }
        else {
            return TempLow;
        }
    }
    public String getTemp(){   //Change this method to return the data received from DHU

        //double tempValue =  Double.parseDouble(MainActivity.temp);
        return MainActivity.temp;
    }

}

