package com.coolweather.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class zhuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        Button tianqi=(Button) findViewById(R.id.tianqi);
        tianqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t=new Intent(zhuActivity.this,MainActivity.class);
                startActivity(t);
            }
        });
        Button movie=(Button)findViewById(R.id.movie);
        movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m=new Intent(zhuActivity.this,shipinActivity.class);
                startActivity(m);
            }
        });
        Button dianhua=(Button)findViewById(R.id.phone);
        dianhua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d=new Intent(zhuActivity.this,phoneActivity.class);
                startActivity(d);
            }
        });
    }
}
