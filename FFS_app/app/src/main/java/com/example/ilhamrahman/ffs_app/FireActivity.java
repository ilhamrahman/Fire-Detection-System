package com.example.ilhamrahman.ffs_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class FireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        Intent fire = getIntent();
        boolean fire_button = fire.getBooleanExtra(MainActivity.FIRE, false);

        //Set toggleActivity's switch to the boolean from MainActivity.ToggleButton
        //Switch ToggleButtonStatus = (Switch) findViewById(R.id.switch3);
        //ToggleButtonStatus.setChecked(fire_button);

        String message = fire.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(fireMessage());

        //Set up for Home Button OnClick
        Button homeButton = (Button) findViewById(R.id.homeButtonF);

        homeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent homeIntent = new Intent(FireActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });
    }

    public String fireMessage() {

        String noFire = "RELAX! There is no danger of fire in your house.";
        String yesFire = "DANGER! Fire was detected in your house!";

        int fireValue =  Integer.parseInt(MainActivity.fire);

        if (fireValue == 0){  //if fire is detected
            return yesFire;   //send warning message
        }
        else {
            return noFire;  //otherwise send relax message
        }
    }
}
