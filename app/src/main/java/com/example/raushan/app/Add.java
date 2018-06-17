package com.example.raushan.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed5;
    String s1,s2,s3,s4,s5;
    Button b1;
    MySQLiteHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        ed5=(EditText)findViewById(R.id.editText5);
        b1=(Button)findViewById(R.id.button);
        db = new MySQLiteHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = ed1.getText().toString();
                s2 = ed2.getText().toString();
                s3 = ed3.getText().toString();
                s5 = ed5.getText().toString();
                s4=" ";
                db.addroute(new Routes(s1,s2,s3,s4,s5));
                Toast.makeText(Add.this, "Routes Entry Successfull!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Add.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
