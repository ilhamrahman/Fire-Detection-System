package com.example.ilhamrahman.ffs_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import java.io.IOException;
import java.net.*;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String FIRE = "com.example.myfirstapp.FIRE";
    public static final String SMOKE = "com.example.myfirstapp.SMOKE";
    public static final String TEMPERATURE = "com.example.myfirstapp.TEMPERATURE";

    public static String temp;
    public static String fire;
    public static String smoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Opening FireActivity OnClick
        Button fireButton = (Button) findViewById(R.id.fireButton);

        fireButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent fireIntent = new Intent(MainActivity.this, FireActivity.class);
                startActivity(fireIntent);
            }
        });


        //Opening SmokeActivity OnClick
        Button smokeButton = (Button) findViewById(R.id.smokeButton);

        smokeButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent smokeIntent = new Intent(MainActivity.this, SmokeActivity2.class);
                startActivity(smokeIntent);
            }
        });


        //Opening TemperatureActivity OnClick
        Button tempButton = (Button) findViewById(R.id.tempButton);

        tempButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent tempIntent = new Intent(MainActivity.this, TempActivity.class);
                startActivity(tempIntent);
            }
        });
    }
    public String receive(int port) throws IOException {

        @SuppressWarnings("resource")
        DatagramSocket serverSocket = new DatagramSocket(port);
        byte[] receiveData = new byte[80];
        //System.out.printf("Listening on udp:%s:%d%n", InetAddress.getLocalHost().getHostAddress(), port);
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        String data = new String(receivePacket.getData(), 0, receivePacket.getLength() );

        return data;
    }
    public void splitString(int port) throws IOException {
            String[] split = receive(port).split(":", 3);   //":" is the character at which the string will split into an array of 3 elements
            temp = split[0]; //The first element of the array is the temperature data
            fire = split[1];  //The second element of the array is the fire data
            smoke = split[2]; //The third element of the string is the smoke data

    }







/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    */
}
    /*
    public void pressButton(){

        final Intent buttonIntent = new Intent(this, FireActivity.class);
        final ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (toggleButton.isChecked()) {
                    buttonIntent.putExtra(FIRE, true);
                    startActivity(buttonIntent);
                } else {
                    buttonIntent.putExtra(FIRE, false);
                    startActivity(buttonIntent);
                }
            }
        });
    }
    */

