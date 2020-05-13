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
import com.example.datainstansi.model.district.purwakarta.PurwakartaDiscoverInstansiItems;

import java.util.ArrayList;

public class PurwakartaDiscoverAdapter extends RecyclerView.Adapter<PurwakartaDiscoverAdapter.ViewHolder> {


    private Context context;
    private ArrayList<PurwakartaDiscoverInstansiItems> purwakartaDiscoverItem = new ArrayList<>();

    public PurwakartaDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<PurwakartaDiscoverInstansiItems> items) {
        purwakartaDiscoverItem.clear();
        purwakartaDiscoverItem.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PurwakartaDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_subdata,parent,false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PurwakartaDiscoverAdapter.ViewHolder holder, int position) {
        holder.tvTitle.setText(purwakartaDiscoverItem.get(position).getNamaInstansi().toString());
        holder.tvId.setText(purwakartaDiscoverItem.get(position).getId().toString());
        holder.tvIdKabupaten.setText(purwakartaDiscoverItem.get(position).getIdKabupaten().toString());
        holder.tvNamaKabupaten.setText(purwakartaDiscoverItem.get(position).getNamaKabupaten().toString());
        holder.tvJenisInstansi.setText(purwakartaDiscoverItem.get(position).getJenisInstansi().toString());
        holder.tvNamaInstansi.setText(purwakartaDiscoverItem.get(position).getNamaInstansi().toString());
        holder.tvNomorInstansi.setText(purwakartaDiscoverItem.get(position).getNomorInstansi().toString());
        holder.tvAlamatInstansi.setText(purwakartaDiscoverItem.get(position).getAlamatInstansi().toString());
        holder.tvLat.setText(purwakartaDiscoverItem.get(position).getLat().toString());
        holder.tvLong.setText(purwakartaDiscoverItem.get(position).getLong().toString());
    }

    @Override
    public int getItemCount() {
        return purwakartaDiscoverItem.size();
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
