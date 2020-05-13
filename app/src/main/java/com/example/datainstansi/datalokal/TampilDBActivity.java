package com.example.datainstansi.datalokal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datainstansi.R;
import com.example.datainstansi.database.AppDatabase;

public class TampilDBActivity extends AppCompatActivity {

    private AppDatabase appDatabase;
    private RecyclerView rc;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);

        appDatabase = AppDatabase.intDB(this);

        rc = findViewById(R.id.list_data);
        rc.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        read();
    }

    public void read(){
        AdapterDB adapterDB = new AdapterDB(appDatabase.dao().getData(), this);
        rc.setAdapter(adapterDB);
    }
}
