package com.example.heroregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heroregistration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.saveBoton.setOnClickListener {
            val superHeroName= binding.heroNameEdit.text.toString()
            val alterEgo=binding.alteregoEdit.text.toString()
            val biografia= binding.biografiaEditText.text.toString()
            val power=binding.ratingBar.rating

            val hero= Superhero(superHeroName,alterEgo,biografia,power)
            openDetailActivity(hero)

        }
    }

    private fun openDetailActivity(superhero:Superhero) {
        //explicit intent != implicit intent
        val intent= Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPERHERO_KEY, superhero)
        startActivity(intent)
    }
}