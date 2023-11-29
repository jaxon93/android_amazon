package com.example.android_amazon.activity

import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_amazon.R
import com.example.android_amazon.adapter.EssentialAdapter
import com.example.android_amazon.adapter.PopularAdapter
import com.example.android_amazon.adapter.SneakerAdapter
import com.example.android_amazon.model.Essential
import com.example.android_amazon.model.Popular
import com.example.android_amazon.model.Sneaker
class MainActivity : AppCompatActivity() {
    lateinit var rv_essential: RecyclerView
    lateinit var rv_sneaker: RecyclerView
    lateinit var rv_popular: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    fun initView() {

        rv_sneaker = findViewById(R.id.rv_sneaker)
        rv_essential = findViewById(R.id.rv_essential)
        rv_popular = findViewById(R.id.rv_popular)

        val manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_essential.layoutManager = manager

        val manager2 = GridLayoutManager(this, 2)
        rv_sneaker.layoutManager = manager2

        val manager3 = GridLayoutManager(this, 2)
        rv_popular.layoutManager = manager3

        refreshAdapter(getEssentials())
        refreshAdapter2(getSneakers())
        refreshAdapter3(getPopulars())

    }

    private fun setLinearHeight(layout: LinearLayout?) {
        // Get screen width programmatically
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        var widthPixels = displayMetrics.widthPixels

        // Set layout width programmatically
        val params: ViewGroup.LayoutParams = layout!!.layoutParams
        params.height = widthPixels
        layout.layoutParams = params
    }

    fun getEssentials(): ArrayList<Essential> {
        val items: ArrayList<Essential> = ArrayList<Essential>()
        items.add(Essential("Oculus", R.drawable.im_product_3))
        items.add(Essential("Gamer", R.drawable.im_product_2))
        items.add(Essential("Mobile", R.drawable.im_product_1))

        return items
    }

    fun refreshAdapter(items: ArrayList<Essential>) {
        val adapter = EssentialAdapter(this, items)
        rv_essential!!.adapter = adapter
    }

    fun getSneakers(): ArrayList<Sneaker> {
        val items: ArrayList<Sneaker> = ArrayList<Sneaker>()
        items.add(Sneaker(R.drawable.im_sneaker_1))
        items.add(Sneaker(R.drawable.im_sneaker_2))
        items.add(Sneaker(R.drawable.im_sneaker_3))
        items.add(Sneaker(R.drawable.im_sneaker_4))

        return items
    }

    fun refreshAdapter2(items: ArrayList<Sneaker>) {
        val adapter = SneakerAdapter(this, items)
        rv_sneaker!!.adapter = adapter
    }

    fun getPopulars(): ArrayList<Popular> {
        val items: ArrayList<Popular> = ArrayList<Popular>()
        items.add(Popular(R.drawable.im_camera_1))
        items.add(Popular(R.drawable.im_camera_2))
        items.add(Popular(R.drawable.im_camera_3))
        items.add(Popular(R.drawable.im_camera_4))

        return items
    }

    fun refreshAdapter3(items: ArrayList<Popular>) {
        val adapter = PopularAdapter(this, items)
        rv_popular!!.adapter = adapter
    }

}