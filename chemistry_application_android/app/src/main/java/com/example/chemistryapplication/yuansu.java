package com.example.chemistryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class yuansu extends AppCompatActivity {
    Button button;
    EditText enm;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuansu);
        button=findViewById(R.id.button6);
        enm=findViewById(R.id.editText2);
        textView=findViewById(R.id.textView2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Data.data2=enm.getText().toString();
                if(Data.data2.equals("na"))
                {*/
                Data.name=enm.getText().toString();
                Cominacation com=new Cominacation();
                com.TestServlet();
                //}
            }
        });
    }
}
