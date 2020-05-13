package com.example.datainstansi.datalokal;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datainstansi.R;
import com.example.datainstansi.database.AppDatabase;
import com.example.datainstansi.database.DataMessage;

public class AdapterDBAdmin extends RecyclerView.Adapter<AdapterDBAdmin.ViewHolder> {
    private DataMessage[] list;
    private Context context;

    public AdapterDBAdmin(DataMessage[] list, Context context ) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data_admin, parent, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final DataMessage item = list[position];

        holder.tvNama.setText(item.getNama());
        holder.tvJenisInstansi.setText(item.getJenisInstansi());
        holder.tvNamaInstansi.setText(item.getNamaInstansi());
        holder.tvAlamatInstansi.setText(item.getAlamatInstansi());
        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateDBActivity.class);
                intent.putExtra("nama", item.getNama());
                intent.putExtra("jenis_instansi", item.getJenisInstansi());
                intent.putExtra("nama_instansi", item.getNamaInstansi());
                intent.putExtra("alamat_instansi",item.getAlamatInstansi());
                intent.putExtra("id", item.getId());
                context.startActivity(intent);
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppDatabase appDatabase;
                appDatabase = AppDatabase.intDB(context.getApplicationContext());
                item.setId(item.getId());
                appDatabase.dao().deleteData(item);

                Toast.makeText(context,"Delete Data Success", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, TampilDBAdminActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return list.length ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvJenisInstansi, tvNamaInstansi, tvAlamatInstansi;
        Button btnUpdate, btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            tvJenisInstansi = itemView.findViewById(R.id.tvJenisInstansi);
            tvNamaInstansi = itemView.findViewById((R.id.tvNamaInstansi));
            tvAlamatInstansi = itemView.findViewById(R.id.tvAlamatInstansi);
            btnUpdate = itemView.findViewById(R.id.btnUpdate);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}