package com.example.shaviyomarasinghe.ffs_app;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import java.net.*;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String FIRE = "com.example.myfirstapp.FIRE";
    public static final String SMOKE = "com.example.myfirstapp.SMOKE";
    public static final String TEMPERATURE = "com.example.myfirstapp.TEMPERATURE";

    Handler handler = new Handler(){
        public void handleMesssage(Message msg){
            TextView Flareon = (TextView) findViewById(R.id.textView3);
            Flareon.setText(msg.toString());

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //Opening FireActivity OnClick
//        Button fireButton = (Button) findViewById(R.id.fireButton);
//
//        fireButton.setOnClickListener(new OnClickListener() {
//            public void onClick(View arg0) {
//                Intent fireIntent = new Intent(MainActivity.this, FireActivity.class);
//                startActivity(fireIntent);
//            }
//        });


        //Opening SmokeActivity OnClick
        Button smokeButton = (Button) findViewById(R.id.smokeButton);

        smokeButton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent smokeIntent = new Intent(MainActivity.this, SmokeActivity.class);
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

    public void getPacket(View view) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                String received;
                final int PACKETSIZE = 100;
                DatagramSocket socket = null;
                synchronized (this){
                    try {
                        int port = 3500;
                        InetAddress host = InetAddress.getByName("10.0.0.52");
                        socket = new DatagramSocket(port);
                        byte[] receiveData = new byte[80];
                        boolean testBool = true;
                        while (testBool) {

                            DatagramPacket packet = new DatagramPacket(new byte[PACKETSIZE], PACKETSIZE);   //initialize packet of data to be received
                            socket.receive(packet);     //receive data
                            String DataReceived = new String(packet.getData()).trim();   //string of data received
                            if(DataReceived != ""){
                                Message msg = Message.obtain();
                                msg.obj = DataReceived;
                                handler.handleMessage(msg);
                                testBool = false;
                            }


                        }

                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                }

            }
        };
        Thread startupThread = new Thread(r);
        startupThread.start();
    }

}

