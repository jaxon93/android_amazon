package com.example.android_amazon_java.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.android_amazon_java.R;
import com.example.android_amazon_java.adapter.EssentialAdapter;
import com.example.android_amazon_java.adapter.PopularAdapter;
import com.example.android_amazon_java.adapter.SneakerAdapter;
import com.example.android_amazon_java.model.Essential;
import com.example.android_amazon_java.model.Popular;
import com.example.android_amazon_java.model.Sneaker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_essential;
    private RecyclerView rv_sneaker;
    private RecyclerView rv_popular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rv_sneaker = findViewById(R.id.rv_sneaker);
        rv_essential = findViewById(R.id.rv_essential);
        rv_popular = findViewById(R.id.rv_popular);

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv_essential.setLayoutManager(manager);

        GridLayoutManager manager2 = new GridLayoutManager(this, 2);
        rv_sneaker.setLayoutManager(manager2);

        GridLayoutManager manager3 = new GridLayoutManager(this, 2);
        rv_popular.setLayoutManager(manager3);

        refreshAdapter(getEssentials());
        refreshAdapter2(getSneakers());
        refreshAdapter3(getPopulars());
    }

    private void setLinearHeight(LinearLayout layout) {
        // Get screen width programmatically
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int widthPixels = displayMetrics.widthPixels;

        // Set layout width programmatically
        ViewGroup.LayoutParams params = layout.getLayoutParams();
        params.height = widthPixels;
        layout.setLayoutParams(params);
    }

    private ArrayList<Essential> getEssentials() {
        ArrayList<Essential> items = new ArrayList<>();
        items.add(new Essential("Oculus", R.drawable.im_product_3));
        items.add(new Essential("Gamer", R.drawable.im_product_2));
        items.add(new Essential("Mobile", R.drawable.im_product_1));

        return items;
    }

    private void refreshAdapter(ArrayList<Essential> items) {
        EssentialAdapter adapter = new EssentialAdapter(this, items);
        rv_essential.setAdapter(adapter);
    }

    private ArrayList<Sneaker> getSneakers() {
        ArrayList<Sneaker> items = new ArrayList<>();
        items.add(new Sneaker(R.drawable.im_sneaker_1));
        items.add(new Sneaker(R.drawable.im_sneaker_2));
        items.add(new Sneaker(R.drawable.im_sneaker_3));
        items.add(new Sneaker(R.drawable.im_sneaker_4));

        return items;
    }

    private void refreshAdapter2(ArrayList<Sneaker> items) {
        SneakerAdapter adapter = new SneakerAdapter(this, items);
        rv_sneaker.setAdapter(adapter);
    }

    private ArrayList<Popular> getPopulars() {
        ArrayList<Popular> items = new ArrayList<>();
        items.add(new Popular(R.drawable.im_camera_1));
        items.add(new Popular(R.drawable.im_camera_2));
        items.add(new Popular(R.drawable.im_camera_3));
        items.add(new Popular(R.drawable.im_camera_4));

        return items;
    }

    private void refreshAdapter3(ArrayList<Popular> items) {
        PopularAdapter adapter = new PopularAdapter(this, items);
        rv_popular.setAdapter(adapter);
    }
}