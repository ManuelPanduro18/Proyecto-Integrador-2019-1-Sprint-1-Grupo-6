package com.manuel.backstackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        setTitle(R.string.title_string);
    }

    public void callRegister(View view){
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivityForResult(intent,100);

    }
}
