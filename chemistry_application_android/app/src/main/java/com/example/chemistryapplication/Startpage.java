package com.example.chemistryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Startpage extends AppCompatActivity {

    Button back,button1,button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage);
        back = findViewById(R.id.back2);
        button1 = findViewById(R.id.bixiu1);
        button2 = findViewById(R.id.bixiu2);
        button3 = findViewById(R.id.xuanxiu4);
        button4 = findViewById(R.id.xuanxiuwu);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.data = "bi1";
                Intent intent = new Intent();
                intent.setClass(Startpage.this, shuoming.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.data = "bi2";
                Intent intent = new Intent();
                intent.setClass(Startpage.this, shuoming.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.data = "xuan4";
                Intent intent = new Intent();
                intent.setClass(Startpage.this, shuoming.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.data = "xuan5";
                Intent intent = new Intent();
                intent.setClass(Startpage.this, shuoming.class);
                startActivity(intent);
            }
        });


}


}
