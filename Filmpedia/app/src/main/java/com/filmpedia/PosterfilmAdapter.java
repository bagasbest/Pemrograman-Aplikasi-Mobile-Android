package com.filmpedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;

import java.io.PipedOutputStream;
import java.util.ArrayList;

public class PosterfilmAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Posterfilm> list = new ArrayList<>();

    public PosterfilmAdapter(Context context) {
        this.context = context;
    }

    public void setPosterfilm(ArrayList<Posterfilm> list){
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_view, parent, false );
        }

        ViewHolder vh = new ViewHolder(convertView);
        Posterfilm p = (Posterfilm) getItem(position);
        vh.bind(p);
        return convertView;
    }

    private class ViewHolder{
        private TextView tv_judul, tv_tanggal, tv_desc, tv_rating, tv_genre;
        private ImageView imgg_photo;

        ViewHolder (View v){
           tv_judul = v.findViewById(R.id.tv_judul);
           tv_tanggal = v.findViewById(R.id.tv_terbit);
            tv_desc = v.findViewById(R.id.tv_desc);
            tv_rating = v.findViewById(R.id.tv_rating);
            imgg_photo = v.findViewById(R.id.img_poster);
            tv_genre = v.findViewById(R.id.tv_genre);
        }

        public void bind(Posterfilm posterfilm) {
            Glide.with(imgg_photo)
                    .load(posterfilm.getFoto())
                    .into(imgg_photo);

            tv_judul.setText(posterfilm.getJudul());
            tv_tanggal.setText(posterfilm.getTanggal());
            tv_desc.setText(posterfilm.getDeskripsi());
            tv_rating.setText(posterfilm.getRating());
            tv_genre.setText(posterfilm.getGenre());
        }
    }
}
