package com.example.chemistryapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class shuoming extends AppCompatActivity {
    TextView textView;
    Button button,search;
    EditText ed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuoming);
        textView=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        ed=findViewById(R.id.editText);
        search=findViewById(R.id.search);
        if(Data.data.equals("s"))
        {
            ed.setVisibility(View.GONE);
            search.setVisibility(View.GONE);
            textView.setText("我们是一个由厦门大学化学化工学院，信息学院，电子科技与技术学院的学生组成的团队，致力于为中学生开发涵盖最基础，最广泛内容的化学知识检索APP\n" +
                    "我们的内容以高中化学课本的基础知识点为主，适当拓展课外内容。为了培养学生的实操精神，我们还拍摄了原创的实验视频，加强学生对于知识点的理解记忆");
        }
        else
        {
            ed.setVisibility(View.VISIBLE);
            search.setVisibility(View.VISIBLE);
            textView.setText("请输入知识点标题查询具体知识点：\n\n同时你也可以输入单元、专题、小节来寻找有哪些对应目录" +
                    "或者知识点\n\n样例输入：\n化学键\n阳离子和阴离子的定义\n离子键\n结构式\n\n该搜索支持模糊搜索");
        }

       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data.name=ed.getText().toString();
                Cominacation com=new Cominacation();
                com.TestServlet();
            }
        });


    }
}
