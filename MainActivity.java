package com.example.danang.hellothread;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btStartStop;
    private TextView tvAngka;
    private int angka, angka2, angka3;
    private TextView tvAngka2;
    private TextView tvAngka3;
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvAngka = (TextView) findViewById(R.id.tvAngka);
        this.tvAngka2 = (TextView) findViewById(R.id.tvAngka2);
        this.tvAngka3 = (TextView) findViewById(R.id.tvAngka3);
        this.btStartStop = (Button) findViewById(R.id.btStartStop);

        this.btStartStop.setOnClickListener(this);
    }

    Runnable uiRun = new Runnable() {
        @Override
        public void run() {
            tvAngka.setText(angka + "");
            tvAngka2.setText(angka2 + "");
            tvAngka3.setText(angka3 + "");
        }
    };

    Runnable bgRun = new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    angka = (int) (Math.random() * 10);
                    uiHandler.post(uiRun);
                    Thread.sleep(100);
                }
            }catch (Exception ex){}
        }
    };

    Runnable bgRun2 = new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    angka2 = (int) (Math.random() * 10);
                    uiHandler.post(uiRun);
                    Thread.sleep(100);
                }
            }catch (Exception ex){}
        }
    };

    Runnable bgRun3 = new Runnable() {
        @Override
        public void run() {
            try {
                while (true) {
                    angka3 = (int) (Math.random() * 10);
                    uiHandler.post(uiRun);
                    Thread.sleep(100);
                }
            }catch (Exception ex){}
        }
    };

    Handler uiHandler = new Handler();
    Thread t,t1,t2;
    RandomTask randomTask;
    @Override
    public void onClick(View view) {
        //jika thread belum dibuat/ sudah mati

        if ((t == null|| !t.isAlive()) && (t1 == null|| !t1.isAlive()) && (t2 == null|| !t2.isAlive()) ){
            t = new Thread(bgRun);
            t.start();
            t1 = new Thread(bgRun2);
            t1.start();
            t2 = new Thread(bgRun3);
            t2.start();
        } else if(t.isAlive()) {
            t.interrupt();
        }

        if(!t.isAlive()){
            t1.interrupt();
        }

        if(!t.isAlive() && !t1.isAlive()){
            t2.interrupt();
            if(tvAngka.getText().toString() == tvAngka2.getText().toString()
                    && tvAngka.getText().toString() == tvAngka3.getText().toString()){
                Toast.makeText(getApplicationContext(), "Selamat anda menang", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(), "Maaf coba lagi", Toast.LENGTH_SHORT).show();
            }

        }


        Log.v(TAG, "Angka 1: " +tvAngka.getText().toString());
        Log.v(TAG, "Angka 2: " +tvAngka2.getText().toString());
        Log.v(TAG, "Angka 3: " +tvAngka3.getText().toString());



    }
}
