package com.example.datainstansi.datalokal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datainstansi.R;
import com.example.datainstansi.database.DataMessage;

public class AdapterDB extends RecyclerView.Adapter<AdapterDB.ViewHolder> {
    private DataMessage[] list;
    private Context context;

    public AdapterDB(DataMessage[] list, Context context ) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data, parent, false );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final DataMessage item = list[position];

        holder.tvNama.setText(item.getNama());
        holder.tvJenisInstansi.setText(item.getJenisInstansi());
        holder.tvNamaInstansi.setText(item.getNamaInstansi());
        holder.tvAlamatInstansi.setText(item.getAlamatInstansi());

    }

    @Override
    public int getItemCount() {

        return list.length ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvJenisInstansi, tvNamaInstansi, tvAlamatInstansi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tvNama);
            tvJenisInstansi = itemView.findViewById(R.id.tvJenisInstansi);
            tvNamaInstansi = itemView.findViewById((R.id.tvNamaInstansi));
            tvAlamatInstansi = itemView.findViewById(R.id.tvAlamatInstansi);
        }
    }
}