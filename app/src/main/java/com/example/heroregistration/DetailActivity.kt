package com.example.heroregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heroregistration.databinding.ActivityDetailBinding
import com.example.heroregistration.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val SUPERHERO_KEY = "superhero"

    }
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundle= intent.extras!!
        val superhero=bundle.getParcelable<Superhero>(SUPERHERO_KEY)
/*
        binding.heroName.text=superhero?.nombre
        binding.alterEgotv.text=superhero?.alterego
        binding.biografiaTv.text=superhero?.bio
        binding.powerHero.rating=superhero?.rating ?: 0.0f*/

        //el superhero viene del xml, declarada la variable del data binding
        binding.superhero = superhero


    }
}