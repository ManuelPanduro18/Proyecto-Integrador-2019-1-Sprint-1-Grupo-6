package com.manuel.backstackapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView usernametext;
    private ListView contactlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.page_main);

        usernametext=findViewById(R.id.username_text);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        if(bundle!=null){
            String username=bundle.getString("username");
            if (username!=null){
                //imprimir el usuario
                usernametext.setText(username);
            }
        }

        //Lista
        contactlist=findViewById(R.id.contac_list);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        adapter.add("Juan Perez");
        adapter.add("Edson Manuel");
        adapter.add("Juan Pablo");
        adapter.add("Adrian Palacios");
        contactlist.setAdapter(adapter);


    }
    public void callRegister(View view){
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivityForResult(intent,100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100){
            if (resultCode==RESULT_OK){
                Bundle bundle=data.getExtras();
                if(bundle!=null){
                    String fullname=bundle.getString("fullname");
                    Toast.makeText(this,"contacto "+ fullname, Toast.LENGTH_SHORT).show();
                    //Añadir a listview
                    ArrayAdapter<String> adapter=(ArrayAdapter<String>)contactlist.getAdapter();
                    adapter.add(fullname);
                    adapter.notifyDataSetChanged(); //para refrescar
                }
            }
        }
    }
}
