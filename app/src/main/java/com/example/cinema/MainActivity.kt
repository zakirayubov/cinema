package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.adapter.FilmAdapter
import com.example.cinema.model.Category
import com.example.cinema.model.Film

class MainActivity : AppCompatActivity() {

    lateinit var filmRecycler: RecyclerView
    lateinit var filmAdapter: FilmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val films: MutableList<Film> = mutableListOf()
        films.add(Film(1, "doll", "film_page2","#09090F", "Doll 3",  "film pro DOLL", Category.HORROR))
        films.add(Film(2, "di_des", "film_page2", "#F08080", "DI DESSA",  "film pro DI DESSA", Category.HORROR))
        films.add(Film(3, "gun", "film_page2","#09090F", "TOP GUN",  "film pro TOP GUN", Category.HORROR))
        films.add(Film(4, "sedap", "film_page2","#09090F", "SEDAP",  "film pro SEDUP", Category.COMEDY))

        setFilmRecycler(films)
    }

    private fun setFilmRecycler(films: MutableList<Film>) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        filmRecycler = findViewById(R.id.filmRecycler)
        filmRecycler.layoutManager = layoutManager

        filmAdapter = FilmAdapter(this, films)
        filmRecycler.adapter = filmAdapter

    }
}