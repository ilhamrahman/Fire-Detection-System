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
        status.setText(getTempStatus());


        //Set up for Home Button OnCLick
        Button homeButton = (Button) findViewById(R.id.homeButtonT);

        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent homeIntent = new Intent(TempActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });
    }

    public static String getTempStatus(){   //Change this method to return the data received from DHU
        String t_status = "The current temperature is at comfortable level under the set threshold. You can RELAX!";

        return t_status;
    }
    public String getTemp(){   //Change this method to return the data received from DHU
        double currentTemp = 25.2;
        String tempString = Double.toString(currentTemp);
        return tempString;
    }
}

