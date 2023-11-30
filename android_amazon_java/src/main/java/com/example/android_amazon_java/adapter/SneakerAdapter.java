package com.example.android_amazon_java.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android_amazon_java.R;
import com.example.android_amazon_java.model.Sneaker;

import java.util.ArrayList;

public class SneakerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Sneaker> items;

    public SneakerAdapter(Context context, ArrayList<Sneaker> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sneaker, parent, false);
        setLinearHeight(view);
        return new SneakerViewHolder(view);
    }

    public class SneakerViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_image;

        public SneakerViewHolder(View view) {
            super(view);
            iv_image = view.findViewById(R.id.iv_sneaker);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Sneaker item = items.get(position);

        if (holder instanceof SneakerViewHolder) {
            SneakerViewHolder sneakerViewHolder = (SneakerViewHolder) holder;
            sneakerViewHolder.iv_image.setImageResource(item.getImage());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private void setLinearHeight(View itemView) {
        // Get screen width programmatically
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);
        int widthPixels = displayMetrics.widthPixels;

        // Set layout width programmatically
        ViewGroup.LayoutParams params = itemView.getLayoutParams();
        params.width = (widthPixels / 2) - dpToPx(context, 6);
        params.height = (widthPixels / 2) - dpToPx(context, 6);

        itemView.setLayoutParams(params);
    }

    private int dpToPx(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }
}