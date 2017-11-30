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

        Thread thread = new Thread(this);
        thread.run();
        thread.start();
    }

    public void run() {

        final int PACKETSIZE = 100;
        android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);
        DatagramSocket socket = null;

        try {
            // Convert the argument to ensure that is it valid
            //int port = Integer.parseInt(args[1]);                  //port number
            int port = 3600;
//            InetAddress host = InetAddress.getByName(args[0]);     //host address
            InetAddress host = InetAddress.getByName("10.0.0.53");
            socket = new DatagramSocket(port);                       //socket

            // Construct the socket
            //DatagramSocket socket = new DatagramSocket( port ) ;

            for (; ; ) {
                DatagramPacket packet = new DatagramPacket(new byte[PACKETSIZE], PACKETSIZE);   //initialize packet of data to be received
                socket.receive(packet);     //receive data
                String DataReceived = new String(packet.getData()).trim();   //string of data received
                System.out.println(DataReceived);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
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

