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
                    textView.setText("钠是一种金属元素，在周期表中位于第3周期、第ⅠA族，是碱金属元素的代表，质地柔软，能与水反应生成氢氧化钠，放出氢气，化学性质较活泼。钠元素以盐的形式广泛的分布于陆地和海洋中，钠也是人体肌肉组织和神经组织中的重要成分之一。" +
                            "4Na + O2= 2Na2O （常温）\n" +
                            "2Na+O2= Na2O2（加热或点燃）\n" +
                            "2Na+2H2O=2NaOH+H2↑\n" +
                            "2Na+2CO2 = Na2CO3+CO\n" +
                            "2Na+2ROH=2RONa+H2↑ （ROH表示低元醇）\n" +
                            "2Na + 2NH3（L）= 2NaNH2 + H2↑（此反应中“2NH3（L）”表示液氨）");
                //}
            }
        });
    }
}
