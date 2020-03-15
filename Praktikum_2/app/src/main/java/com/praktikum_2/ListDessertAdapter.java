package com.praktikum_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListDessertAdapter extends RecyclerView.Adapter<ListDessertAdapter.ListViewHolder> {
    private ArrayList<Dessert> listDessert;

    public ListDessertAdapter(ArrayList<Dessert> list) {
        this.listDessert = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_menu, parent,  false);
        return new ListViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Dessert dessert = listDessert.get(position);
        Glide.with(holder.itemView.getContext())
                .load(dessert.getFoto())
                .apply(new RequestOptions().override(150, 150))
                .into(holder.gambar);
        holder.tvNama.setText(dessert.getNama());
        holder.tvDetail.setText(dessert.getDetail());


    }

    @Override
    public int getItemCount() {
        return listDessert.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvDetail;
        ImageView gambar;

        ListViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.img_item_photo);
            tvNama = itemView.findViewById(R.id.tv_name);
            tvDetail = itemView.findViewById(R.id.tv_detail);
        }
    }


}
