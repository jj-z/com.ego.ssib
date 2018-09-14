//package com.ego.ssib;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//public class MainActivity extends AppCompatActivity {
//
//    PrefManager prefManager;
//    private Button button;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        prefManager = new PrefManager(this);
//
//
//        button = (Button) findViewById(R.id.btn_again);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                prefManager.setFirstTimeLaunch(true);
//                finish();
//            }
//        });
//    }
//}
//
//
package com.ego.ssib;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    PrefManager prefManager;
    private Button button;
    private int time = 6;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefManager = new PrefManager(this);


        button = (Button) findViewById(R.id.btn_time);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                time--;
                if (time >= 0){
                    button.setText("倒计时" + time + "秒");
                    handler.postDelayed(this,1000);
                }else{
                    startActivity(new Intent(MainActivity.this,io.dcloud.PandoraEntry.class));
                    finish();
                }

            }
        },1000);
    }
}