package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class FilmPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_page)

        val filmBg: ConstraintLayout = findViewById(R.id.filmPageBg)
        val filmImage: ImageView = findViewById(R.id.filmImage)
        val filmName: TextView = findViewById(R.id.filmNamePage)
        val filmDesc: TextView = findViewById(R.id.filmDesc)

        filmBg.setBackgroundColor(intent.getIntExtra("filmBg", 0))
        filmImage.setImageResource(intent.getIntExtra("filmImage", 0))
        filmName.text = intent.getStringExtra("filmName")
        filmDesc.text = intent.getStringExtra("filmDesc")
    }
}