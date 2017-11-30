package com.example.ilhamrahman.ffs_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SmokeActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoke2);

        Intent smoke = getIntent();
        boolean smoke_button = smoke.getBooleanExtra(MainActivity.SMOKE, false);


        String message = smoke.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView8);
        textView.setText(smokeMessage());


        //Set up for Home Button OnCLick
        Button homeButton = (Button) findViewById(R.id.homeButtonS);

        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent homeIntent = new Intent(SmokeActivity2.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });
    }


    public String smokeMessage() {
        String noSmoke = "RELAX! There is no danger of smoke in your house.";
        String yesSmoke = "DANGER! Smoke was detected in your house!";

        int smokeValue =  Integer.parseInt(MainActivity.smoke);

        if (smokeValue == 1){ //if smoke is detected
            return yesSmoke;  //send warning message
        }
        else {
            return noSmoke;   //otherwise send relax message
        }
    }

}
