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
            openDetailActivity(superHeroName,alterEgo,biografia,power)

        }
    }

    private fun openDetailActivity(name:String, alter:String, bio:String, power:Float) {
        val intent= Intent(this, DetailActivity::class.java)
        intent.putExtra("superhero_name", name)
        intent.putExtra("alterego_hero",alter)
        intent.putExtra("biografia_hero",bio)
        intent.putExtra("power_hero",power)
        startActivity(intent)
    }
}