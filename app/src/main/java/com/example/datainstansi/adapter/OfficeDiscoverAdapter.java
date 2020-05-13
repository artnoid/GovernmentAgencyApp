package com.example.datainstansi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.datainstansi.R;
import com.example.datainstansi.model.all.AllDiscoverInstansiItem;

import java.util.ArrayList;

public class OfficeDiscoverAdapter extends RecyclerView.Adapter<OfficeDiscoverAdapter.ViewHolder> {

    private Context context;
    private ArrayList<AllDiscoverInstansiItem> officeDiscoverItem = new ArrayList<>();

    public OfficeDiscoverAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<AllDiscoverInstansiItem> items) {
        officeDiscoverItem.clear();
        officeDiscoverItem.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public OfficeDiscoverAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_data,parent,false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OfficeDiscoverAdapter.ViewHolder holder, final int position) {
        holder.tvOffice.setText(officeDiscoverItem.get(position).getNamaInstansi().toString());
        holder.cvData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,officeDiscoverItem.get(position).getNamaInstansi().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return officeDiscoverItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvOffice;
        CardView cvData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvOffice = itemView.findViewById(R.id.tvData);
            cvData = itemView.findViewById(R.id.itemdata_cv);
        }
    }
}
