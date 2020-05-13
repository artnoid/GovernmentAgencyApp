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
import com.example.datainstansi.model.district.jakarta_barat.JakbarDiscoverInstansiItem;
import com.example.datainstansi.model.district.jakarta_timur.JaktimDiscoverInstansiItem;

import java.util.ArrayList;

public class JaktimDiscoverAdapter extends RecyclerView.Adapter<JaktimDiscoverAdapter.ViewHolder> {

    private Context context;
    private ArrayList<JaktimDiscoverInstansiItem> jaktimDiscoverItem = new ArrayList<>();

    public JaktimDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<JaktimDiscoverInstansiItem> items) {
        jaktimDiscoverItem.clear();
        jaktimDiscoverItem.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public JaktimDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_subdata,parent,false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final JaktimDiscoverAdapter.ViewHolder holder, int position) {
        holder.tvTitle.setText(jaktimDiscoverItem.get(position).getNamaInstansi().toString());
        holder.tvId.setText(jaktimDiscoverItem.get(position).getId().toString());
        holder.tvIdKabupaten.setText(jaktimDiscoverItem.get(position).getIdKabupaten().toString());
        holder.tvNamaKabupaten.setText(jaktimDiscoverItem.get(position).getNamaKabupaten().toString());
        holder.tvJenisInstansi.setText(jaktimDiscoverItem.get(position).getJenisInstansi().toString());
        holder.tvNamaInstansi.setText(jaktimDiscoverItem.get(position).getNamaInstansi().toString());
        holder.tvNomorInstansi.setText(jaktimDiscoverItem.get(position).getNomorInstansi().toString());
        holder.tvAlamatInstansi.setText(jaktimDiscoverItem.get(position).getAlamatInstansi().toString());
        holder.tvLat.setText(jaktimDiscoverItem.get(position).getLat().toString());
        holder.tvLong.setText(jaktimDiscoverItem.get(position).getLong().toString());
    }

    @Override
    public int getItemCount() {
        return jaktimDiscoverItem.size();
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
