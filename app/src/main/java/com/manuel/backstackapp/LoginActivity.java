package com.manuel.backstackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameInput;
    private EditText passwordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameInput=findViewById(R.id.username_input);
        passwordInput=findViewById(R.id.password_input);

    }
    public static Map<String, String> ALL_USERS=new HashMap<>();
    static {
        ALL_USERS.put("emanuel@gmail.com","12345");
        ALL_USERS.put("mgalvez@gmial.com","123456");
        ALL_USERS.put("jfarfan","tecsup");
    }

    public void calllogin(View view){
        String username=usernameInput.getText().toString();
        String password=passwordInput.getText().toString();
        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(this,"Ingrese todos los campos",Toast.LENGTH_SHORT).show();
            return;
        }
        //validad ese username y password
        String pass=ALL_USERS.get(username);
        if(pass==null){
            Toast.makeText(this,"usuario no existe", Toast.LENGTH_SHORT).show();
            return;
        }else{
            if(!pass.equals(password)){
                Toast.makeText(this,"Clave incorrecta", Toast.LENGTH_SHORT).show();
                return;
            }
        }


        Intent intent=new Intent(this, PrincipalActivity.class);
        intent.putExtra("username", username);

        startActivity(intent);
        finish();
    }
}
