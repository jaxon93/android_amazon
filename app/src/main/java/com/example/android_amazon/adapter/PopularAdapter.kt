package com.example.android_amazon.adapter

import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_amazon.R
import com.example.android_amazon.model.Popular
import com.example.android_amazon.model.Sneaker

class PopularAdapter(var context: Context, var items: ArrayList<Popular>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular, parent, false)
        setLinearHeight(view)
        return PopularViewHolder(view)
    }

    class PopularViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_popular: ImageView
        init {
            iv_popular = view.findViewById(R.id.iv_popular)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if(holder is PopularViewHolder) {
            var iv_popular = holder.iv_popular

            iv_popular.setImageResource(item.image)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    private fun setLinearHeight(itemView: View) {
        // Get screen width programmatically
        val displayMetrics = DisplayMetrics()
        (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(displayMetrics)
        val widthPixels = displayMetrics.widthPixels

        // Set layout width programmatically
        val params: ViewGroup.LayoutParams = itemView.layoutParams
        params.width = (widthPixels / 2)
        params.height = (widthPixels / 2)

        itemView.layoutParams = params
    }

}