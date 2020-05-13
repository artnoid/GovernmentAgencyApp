package com.example.datainstansi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datainstansi.R;
import com.example.datainstansi.model.all.AllDiscoverInstansiItem;

import java.util.ArrayList;

public class AllDiscoverAdapter extends RecyclerView.Adapter<AllDiscoverAdapter.ViewHolder> {

    private Context context;
    private ArrayList<AllDiscoverInstansiItem> allDiscoverItem = new ArrayList<>();

    public AllDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<AllDiscoverInstansiItem> items) {
        allDiscoverItem.clear();
        allDiscoverItem.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AllDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_subdata,parent,false
        );
        return new AllDiscoverAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AllDiscoverAdapter.ViewHolder holder, int position) {
        holder.tvTitle.setText(allDiscoverItem.get(position).getNamaInstansi().toString());
        holder.tvId.setText(allDiscoverItem.get(position).getId().toString());
        holder.tvIdKabupaten.setText(allDiscoverItem.get(position).getIdKabupaten().toString());
        holder.tvNamaKabupaten.setText(allDiscoverItem.get(position).getNamaKabupaten().toString());
        holder.tvJenisInstansi.setText(allDiscoverItem.get(position).getJenisInstansi().toString());
        holder.tvNamaInstansi.setText(allDiscoverItem.get(position).getNamaInstansi().toString());
        holder.tvNomorInstansi.setText(allDiscoverItem.get(position).getNomorInstansi().toString());
        holder.tvAlamatInstansi.setText(allDiscoverItem.get(position).getAlamatInstansi().toString());
        holder.tvLat.setText(allDiscoverItem.get(position).getLat().toString());
        holder.tvLong.setText(allDiscoverItem.get(position).getLongg().toString());
    }

    @Override
    public int getItemCount() {
        return allDiscoverItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvIdKabupaten, tvNamaKabupaten, tvJenisInstansi, tvNamaInstansi,
                tvNomorInstansi, tvAlamatInstansi, tvLat, tvLong, tvTitle;
        CardView cvSubData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvId = itemView.findViewById(R.id.tvId);
            tvIdKabupaten = itemView.findViewById(R.id.tvIdKabupaten);
            tvNamaKabupaten = itemView.findViewById(R.id.tvNamaKabupaten);
            tvJenisInstansi = itemView.findViewById(R.id.tvJenisInstansi);
            tvNamaInstansi = itemView.findViewById(R.id.tvNamaInstansi);
            tvNomorInstansi = itemView.findViewById(R.id.tvNomorInstansi);
            tvAlamatInstansi = itemView.findViewById(R.id.tvAlamatInstansi);
            tvLat = itemView.findViewById(R.id.tvLat);
            tvLong = itemView.findViewById(R.id.tvLong);
            cvSubData = itemView.findViewById(R.id.itemsubdata_cv);

        }
    }
}
