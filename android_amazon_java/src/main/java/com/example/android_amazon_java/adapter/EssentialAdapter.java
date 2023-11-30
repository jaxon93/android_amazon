package com.example.android_amazon_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android_amazon_java.R;
import com.example.android_amazon_java.model.Essential;

import java.util.ArrayList;

public class EssentialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Essential> items;

    public EssentialAdapter(Context context, ArrayList<Essential> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_essential, parent, false);
        return new EssentialViewHolder(view);
    }

    public class EssentialViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_image;
        TextView tv_title;

        public EssentialViewHolder(View view) {
            super(view);
            iv_image = view.findViewById(R.id.iv_image);
            tv_title = view.findViewById(R.id.tv_title);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Essential item = items.get(position);

        if (holder instanceof EssentialViewHolder) {
            EssentialViewHolder essentialViewHolder = (EssentialViewHolder) holder;
            essentialViewHolder.iv_image.setImageResource(item.getImage());
            essentialViewHolder.tv_title.setText(item.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
