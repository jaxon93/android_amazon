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
import com.example.android_amazon_java.model.Popular;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Popular> items;

    public PopularAdapter(Context context, ArrayList<Popular> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popular, parent, false);
        setLinearHeight(view);
        return new PopularViewHolder(view);
    }

    public class PopularViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_popular;

        public PopularViewHolder(View view) {
            super(view);
            iv_popular = view.findViewById(R.id.iv_popular);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Popular item = items.get(position);

        if (holder instanceof PopularViewHolder) {
            PopularViewHolder popularViewHolder = (PopularViewHolder) holder;
            popularViewHolder.iv_popular.setImageResource(item.getImage());
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
