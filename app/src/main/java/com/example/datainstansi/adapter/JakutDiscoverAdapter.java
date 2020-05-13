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
import com.example.datainstansi.model.district.jakarta_utara.JakutDiscoverInstansiItem;

import java.util.ArrayList;

public class JakutDiscoverAdapter extends RecyclerView.Adapter<JakutDiscoverAdapter.ViewHolder> {

    private Context context;
    private ArrayList<JakutDiscoverInstansiItem> jakutDiscoverItem = new ArrayList<>();

    public JakutDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<JakutDiscoverInstansiItem> items) {
        jakutDiscoverItem.clear();
        jakutDiscoverItem.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public JakutDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_subdata,parent,false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final JakutDiscoverAdapter.ViewHolder holder, int position) {
        holder.tvTitle.setText(jakutDiscoverItem.get(position).getNamaInstansi().toString());
        holder.tvId.setText(jakutDiscoverItem.get(position).getId().toString());
        holder.tvIdKabupaten.setText(jakutDiscoverItem.get(position).getIdKabupaten().toString());
        holder.tvNamaKabupaten.setText(jakutDiscoverItem.get(position).getNamaKabupaten().toString());
        holder.tvJenisInstansi.setText(jakutDiscoverItem.get(position).getJenisInstansi().toString());
        holder.tvNamaInstansi.setText(jakutDiscoverItem.get(position).getNamaInstansi().toString());
        holder.tvNomorInstansi.setText(jakutDiscoverItem.get(position).getNomorInstansi().toString());
        holder.tvAlamatInstansi.setText(jakutDiscoverItem.get(position).getAlamatInstansi().toString());
        holder.tvLat.setText(jakutDiscoverItem.get(position).getLat().toString());
        holder.tvLong.setText(jakutDiscoverItem.get(position).getLong().toString());
    }

    @Override
    public int getItemCount() {
        return jakutDiscoverItem.size();
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
