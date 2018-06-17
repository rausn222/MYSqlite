package com.example.raushan.app;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import org.w3c.dom.Text;

public class Dashboard extends AppCompatActivity {
    TextView tv,tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tv = (TextView)findViewById(R.id.txt);
        tv1 = (TextView)findViewById(R.id.txt1);
        final String proptype = getIntent().getStringExtra("username");
        final String j = getIntent().getStringExtra("j");
        tv.setText("Welcome :"+proptype);
        tv1.setText("You have opted"+j);
    }
}
