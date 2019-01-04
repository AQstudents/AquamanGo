package com.coolweather.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class zhuceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        Button back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back=new Intent(zhuceActivity.this,loginActivity.class);
                startActivity(back);
            }
        });
        Button zhuce=(Button)findViewById(R.id.queren);
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText account=(EditText)findViewById(R.id.yhm1);
                EditText password=(EditText)findViewById(R.id.pw1);
                EditText password1=(EditText)findViewById(R.id.pw2);
                if ((password.getText().toString().equals(password1.getText().toString()))){
                    IDPASSWORD user=new IDPASSWORD();
                    user.setAccount(account.getText().toString());
                    user.setPassword(password.getText().toString());
                    user.save();
                    Toast.makeText(zhuceActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    Intent m=new Intent(zhuceActivity.this,loginActivity.class);
                    startActivity(m);
                }
                else{
                    Toast.makeText(zhuceActivity.this,"两次密码不一致",Toast.LENGTH_SHORT).show();
                    password.getText().clear();
                    password1.getText().clear();
                }
            }
        });

    }
}
