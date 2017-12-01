package com.example.ilhamrahman.ffs_app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String FIRE = "com.example.myfirstapp.FIRE";
    public static final String SMOKE = "com.example.myfirstapp.SMOKE";
    public static final String TEMPERATURE = "com.example.myfirstapp.TEMPERATURE";

    public static String temp;
    public static String fire;
    public static String smoke;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread myThread = new Thread(new ServerThread());
        myThread.start();


        //Opening FireActivity OnClick
        Button fireButton = (Button) findViewById(R.id.fireButton);
        fireButton.setOnClickListener(onClickListener);

        Button smokeButton = (Button) findViewById(R.id.smokeButton);
        smokeButton.setOnClickListener(onClickListener);

        Button tempButton = (Button) findViewById(R.id.tempButton);
        tempButton.setOnClickListener(onClickListener);
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            switch(view.getId()){
                case R.id.fireButton:
                    Intent fireIntent = new Intent(MainActivity.this, FireActivity.class);
                    startActivity(fireIntent);
                    break;
                case R.id.smokeButton:
                    Intent smokeIntent = new Intent(MainActivity.this, SmokeActivity2.class);
                    startActivity(smokeIntent);
                    break;
                case R.id.tempButton:
                    Intent tempIntent = new Intent(MainActivity.this, TempActivity.class);
                    startActivity(tempIntent);
                    break;
            }

        }

    };




    class ServerThread implements Runnable {
        Socket s;
        ServerSocket ss;
        InputStreamReader isr;
        BufferedReader bufferedReader;

        Handler h = new Handler();

        @Override
        public void run() {

            try {
                ServerSocket ss = new ServerSocket(6000);
                while (true) {
                    s = ss.accept();
                    isr = new InputStreamReader(s.getInputStream());
                    bufferedReader = new BufferedReader(isr);
                    message = bufferedReader.readLine();

                    h.post(new Runnable() {
                        @Override
                        public void run() {
                            String[] split = message.split(":", 5);   //":" is the character at which the string will split into an array of 3 elements
                            temp = split[1]; //The first element of the array is the temperature data
                            fire = split[2];  //The second element of the array is the fire data
                            smoke = split[3]; //The third element of the string is the smoke data

//                            TextView textView = (TextView) findViewById(R.id.textView13);
//                            textView.setText(fire);
//
//                            TextView textView2 = (TextView) findViewById(R.id.textView14);
//                            textView2.setText(smoke);
//
//                            TextView textView3 = (TextView) findViewById(R.id.textView15);
//                            textView3.setText(temp);
                        }
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }




}



