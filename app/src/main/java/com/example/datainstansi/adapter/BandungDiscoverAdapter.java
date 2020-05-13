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
import com.example.datainstansi.model.district.bandung.BandungDiscoverInstansiItem;

import java.util.ArrayList;

public class BandungDiscoverAdapter extends RecyclerView.Adapter<BandungDiscoverAdapter.ViewHolder> {

    private Context context;
    private ArrayList<BandungDiscoverInstansiItem> bandungDiscoverItem = new ArrayList<>();

    public BandungDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<BandungDiscoverInstansiItem> items) {
        bandungDiscoverItem.clear();
        bandungDiscoverItem.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BandungDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_subdata,parent,false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final BandungDiscoverAdapter.ViewHolder holder, int position) {
        holder.tvTitle.setText(bandungDiscoverItem.get(position).getNamaInstansi().toString());
        holder.tvId.setText(bandungDiscoverItem.get(position).getId().toString());
        holder.tvIdKabupaten.setText(bandungDiscoverItem.get(position).getIdKabupaten().toString());
        holder.tvNamaKabupaten.setText(bandungDiscoverItem.get(position).getNamaKabupaten().toString());
        holder.tvJenisInstansi.setText(bandungDiscoverItem.get(position).getJenisInstansi().toString());
        holder.tvNamaInstansi.setText(bandungDiscoverItem.get(position).getNamaInstansi().toString());
        holder.tvNomorInstansi.setText(bandungDiscoverItem.get(position).getNomorInstansi().toString());
        holder.tvAlamatInstansi.setText(bandungDiscoverItem.get(position).getAlamatInstansi().toString());
        holder.tvLat.setText(bandungDiscoverItem.get(position).getLat().toString());
        holder.tvLong.setText(bandungDiscoverItem.get(position).getLong().toString());
    }

    @Override
    public int getItemCount() {
        return bandungDiscoverItem.size();
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
