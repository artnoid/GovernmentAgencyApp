package com.example.datainstansi.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.datainstansi.R;
import com.example.datainstansi.datalokal.TampilDBAdminActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnStart, btnAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnAdmin = findViewById(R.id.btnAdmin);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(MainActivity.this,
                        FragmentActivity.class);
                startActivity(moveIntent);
            }
        });

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(MainActivity.this,
                        TampilDBAdminActivity.class);
                startActivity(moveIntent);
            }
        });
    }
}
