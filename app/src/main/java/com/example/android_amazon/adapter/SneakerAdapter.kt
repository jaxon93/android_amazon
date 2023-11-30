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
import com.example.android_amazon.model.Sneaker

class SneakerAdapter(var context: Context, var items: ArrayList<Sneaker>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sneaker, parent, false)
        setLinearHeight(view)
        return SneakerViewHolder(view)
    }

    class SneakerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_image: ImageView
        init {
            iv_image = view.findViewById(R.id.iv_sneaker)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if(holder is SneakerViewHolder) {
            var iv_image = holder.iv_image

            iv_image.setImageResource(item.image)
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
        params.width = (widthPixels / 2) - dpToPx(context, 6)
        params.height = (widthPixels / 2)- dpToPx(context, 6)

        itemView.layoutParams = params
    }
    fun dpToPx(context: Context, dp: Int): Int {
        return (dp * context.resources.displayMetrics.density).toInt()
    }
}