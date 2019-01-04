package com.coolweather.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class loginActivity extends AppCompatActivity {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass=(CheckBox)findViewById(R.id.remember_pass);
       /*Button createDatabase=(Button) findViewById(R.id.SQL);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
            }
        });*/
        accountEdit=(EditText)findViewById(R.id.account);
        passwordEdit=(EditText)findViewById(R.id.password);
        login=(Button)findViewById(R.id.login);
        boolean isRemember=pref.getBoolean("remember_password",false);
        if (isRemember){
            String account=pref.getString("account","");
            String password=pref.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=accountEdit.getText().toString();
                String password=passwordEdit.getText().toString();
                List<IDPASSWORD> idpasswords= DataSupport.findAll(IDPASSWORD.class);
                IDPASSWORD user=new IDPASSWORD();
                for (IDPASSWORD idpassword:idpasswords){
                    user=idpassword;
                }
                if (account.equals(user.getAccount())&& password.equals(user.getPassword())){

                    editor=pref.edit();
                    if (rememberPass.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }
                    else{
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent=new Intent(loginActivity.this,zhuActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Toast.makeText(loginActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();

                }
            }
        });

        /*Button queryButton=(Button) findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<IDPASSWORD> idpasswords= DataSupport.findAll(IDPASSWORD.class);
             //   IDPASSWORD user1=new IDPASSWORD();
                for (IDPASSWORD idpassword:idpasswords){
                    Log.d("loginActivity","ID是" +idpassword.getAccount());
                    Log.d("loginActivity","password是" +idpassword.getPassword());
                }
            }
        });*/
        TextView zhuce=(TextView)findViewById(R.id.zhuce);
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent zhuce=new Intent(loginActivity.this,zhuceActivity.class);
                startActivity(zhuce);
            }
        });



    }

}
