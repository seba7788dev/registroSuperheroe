package com.example.heroregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heroregistration.databinding.ActivityDetailBinding
import com.example.heroregistration.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bundle= intent.extras!!
        val superhero_name=bundle.getString("superhero_name") ?: ""
        val alterego_hero=bundle.getString("alterego_hero") ?: ""
        val biografia_hero=bundle.getString("biografia_hero") ?: ""
        val power_hero=bundle.getFloat("power_hero")

        binding.heroName.text=superhero_name
        binding.alterEgotv.text=alterego_hero
        binding.biografiaTv.text=biografia_hero
        binding.powerHero.rating=power_hero


    }
}