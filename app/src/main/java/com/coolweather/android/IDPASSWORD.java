package com.coolweather.android;

import org.litepal.crud.DataSupport;

public class IDPASSWORD extends DataSupport{
    private String account;
    private String password;
    public  String getAccount(){
        return account;
    }
    public void setAccount(String account){
        this.account=account;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }

}
