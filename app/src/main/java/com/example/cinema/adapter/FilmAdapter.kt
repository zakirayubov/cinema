package com.example.cinema.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.FilmPage
import com.example.cinema.R
import com.example.cinema.model.Film

data class FilmAdapter (val context: Context, val films: List<Film>) : RecyclerView.Adapter<FilmAdapter.FilmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val filmItems: View = LayoutInflater.from(context).inflate(R.layout.films_item, parent, false)
        return FilmViewHolder(filmItems)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.filmBg.setBackgroundColor(Color.parseColor(films[position].color))

        val id: Int = context.resources.getIdentifier(films[position].imgIcon, "drawable", context.packageName)
        val imagePage: Int = context.resources.getIdentifier(films[position].imgPage, "drawable", context.packageName)
        holder.filmImage.setImageResource(id)
        holder.filmName.text = films[position].name

        holder.itemView.setOnClickListener {
            val intent = Intent(context, FilmPage::class.java)
            intent.putExtra("filmBg", Color.parseColor(films[position].color))
            intent.putExtra("filmName", films[position].name)
            intent.putExtra("filmDesc", films[position].description)
            intent.putExtra("filmImage", imagePage)
            intent.putExtra("filmCategory", films[position].category)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return films.size
    }

      class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var filmBg: LinearLayout = itemView.findViewById(R.id.filmBg)
        val filmImage: ImageView = itemView.findViewById(R.id.filmImageMain)
        val filmName: TextView = itemView.findViewById(R.id.filmName)
    }


}

