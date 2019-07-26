package com.example.batdongbojava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ống nước, lớp cha: thread
        //nguồn nước: runnable
        //khi tác động đến view phải chú ý gọi luồng chính mới (dòng nước) runOnUiThread, vì thread mặc định ko có quyền tương tác với view
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "xin chào", Toast.LENGTH_SHORT).show();
            }
        });
        //chỉ chạy trong vòng đời của activity (cụ thể là oncreate vòng đời của activity)
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //running
//                Log.d("BBB", "xin chào");
//            }
//        });
//        thread.start();

        Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Xin chao", Toast.LENGTH_SHORT).show();
                //running
                handle("Thead A");
            }
        });
        Thread threadb = new Thread(new Runnable() {
            @Override
            public void run() {
                //running

                handle("Thead B");
            }
        });
        threadb.start();
        threada.start();
    }
    //synchronized (trong java) được gắn cho đối tượng hoặc phương thức
    synchronized public void handle(String key) {
        for (int i = 0; i <= 100; i++) {
            Log.d("BBB", key + " : " + i);
        }
    }
}
