package com.example.datainstansi.datalokal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datainstansi.R;
import com.example.datainstansi.database.AppDatabase;
import com.example.datainstansi.database.DataMessage;

public class UpdateDBActivity extends AppCompatActivity {
    private String nama , jenis_instansi, nama_instansi, alamat_instansi;
    private int id;
    private EditText etJenisInstansi, etNamaInstansi, etAlamatInstansi;
    private Button btnUpdate;
    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        appDatabase = AppDatabase.intDB(getApplicationContext());

        Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        jenis_instansi = intent.getStringExtra("jenis_instansi");
        nama_instansi = intent.getStringExtra("nama_instansi");
        alamat_instansi = intent.getStringExtra("alamat_instansi");
        id = intent.getIntExtra("id", 0);

        etJenisInstansi = findViewById(R.id.etJenisInstansi);
        etNamaInstansi = findViewById(R.id.etNamaInstansi);
        etAlamatInstansi = findViewById(R.id.etAlamatInstansi);
        btnUpdate = findViewById(R.id.btnUpdate);

        //TODO 1 : SETtEXT HASIL INTENT TADI
        etJenisInstansi.setText(jenis_instansi);
        etNamaInstansi.setText(nama_instansi);
        etAlamatInstansi.setText(alamat_instansi);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Update Data Success", Toast.LENGTH_SHORT).show();
                update();
            }
        });
    }

    void update() {
        //TODO 1: SIMPAN HASIL INPUTAN KEDALAM STRING TADI
        jenis_instansi = etJenisInstansi.getText().toString();
        nama_instansi = etNamaInstansi.getText().toString();
        alamat_instansi = etAlamatInstansi.getText().toString();

        DataMessage item = new DataMessage();
        item.setNama(nama);
        item.setJenisInstansi(jenis_instansi);
        item.setNamaInstansi(nama_instansi);
        item.setAlamatInstansi(alamat_instansi);
        item.setId(id);

        //TODO 2: PANGGIL FUNGSI UPDATE DAO()
        appDatabase.dao().updateData(item);

        //TODO 3 : FINISH
        finish();
    }

}
