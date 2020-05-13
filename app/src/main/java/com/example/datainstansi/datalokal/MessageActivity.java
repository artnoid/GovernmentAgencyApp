package com.example.datainstansi.datalokal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datainstansi.R;
import com.example.datainstansi.database.AppDatabase;
import com.example.datainstansi.database.DataMessage;
import com.example.datainstansi.view.activity.FragmentActivity;

public class MessageActivity extends AppCompatActivity {

    private EditText etNama, etJenisInstansi, etNamaInstansi, etAlamatInstansi;
    private Button btnInsert;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        appDatabase = AppDatabase.intDB(getApplicationContext());

        etNama = findViewById(R.id.etNama);
        etJenisInstansi = findViewById(R.id.etJenisInstansi);
        etNamaInstansi = findViewById(R.id.etNamaInstansi);
        etAlamatInstansi = findViewById(R.id.etAlamatInstansi);


        btnInsert = findViewById(R.id.btnInsert);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                Toast.makeText(getApplicationContext(),"Send Data Success", Toast.LENGTH_SHORT).show();
                Intent moveIntent = new Intent(MessageActivity.this, FragmentActivity.class);
                startActivity(moveIntent);
            }
        });
    }

    private void insertData() {
        String nama = etNama.getText().toString();
        String jenis_instansi = etJenisInstansi.getText().toString();
        String nama_instansi = etNamaInstansi.getText().toString();
        String alamat_instansi = etAlamatInstansi.getText().toString();

        DataMessage item = new DataMessage();
        item.setNama(nama);
        item.setJenisInstansi(jenis_instansi);
        item.setNamaInstansi(nama_instansi);
        item.setAlamatInstansi(alamat_instansi);


        appDatabase.dao().insertData(item);

        etNama.setText("");
        etJenisInstansi.setText("");
        etNamaInstansi.setText("");
        etAlamatInstansi.setText("");

    }
}
