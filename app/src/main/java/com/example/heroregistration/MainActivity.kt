package com.example.heroregistration

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.PrecomputedText
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.UnusedAppRestrictionsConstants
import com.example.heroregistration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var heroImage:ImageView
    private lateinit var guardarImagen:Bitmap
    private val getContent=registerForActivityResult(ActivityResultContracts.TakePicturePreview()){ bitmap ->
        guardarImagen=bitmap
        heroImage.setImageBitmap(guardarImagen)


    }
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
        heroImage=binding.heroImage
        heroImage.setOnClickListener {
            openCamera()
        }
    }

    private fun openCamera() {

        getContent.launch(null)



    }

    private fun openDetailActivity(superhero:Superhero) {
        //explicit intent != implicit intent
        val intent= Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPERHERO_KEY, superhero)
        intent.putExtra(DetailActivity.BITMAP_KEY,guardarImagen)
        startActivity(intent)
    }




}
/*
*  private fun openCamera() {
        // implicit intent, para abrir la camara
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, 1000)
    }

    private fun openDetailActivity(superhero:Superhero) {
        //explicit intent != implicit intent
        val intent= Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPERHERO_KEY, superhero)
        startActivity(intent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1000 && resultCode == Activity.RESULT_OK){
            //guardo la foto capturada
            val extras=data?.extras
            val heroBitmap=extras?.getParcelable<Bitmap>("data")

            heroImage.setImageBitmap(heroBitmap)
        }
    }*/

//***********************************************************************
//***********************************************************************
// OTRA FORMA
/**

class MainActivity : AppCompatActivity() {
private lateinit var heroImage:ImageView
private lateinit var guardarImagen:Bitmap
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
heroImage=binding.heroImage
heroImage.setOnClickListener {
openCamera()
}
}

private fun openCamera() {
val intent =Intent(MediaStore.ACTION_IMAGE_CAPTURE)
getResult.launch(intent)



}
private val getResult=registerForActivityResult(
ActivityResultContracts.StartActivityForResult()) {
if(it.resultCode == Activity.RESULT_OK){
//val value = it.data?.getStringExtra("input")
val resultado=it.data

val picture= resultado?.extras?.get("data") as Bitmap
guardarImagen=picture


binding.heroImage.setImageBitmap(guardarImagen)
}
}


private fun openDetailActivity(superhero:Superhero) {
//explicit intent != implicit intent
val intent= Intent(this, DetailActivity::class.java)
intent.putExtra(DetailActivity.SUPERHERO_KEY, superhero)
intent.putExtra(DetailActivity.BITMAP_KEY,guardarImagen)
startActivity(intent)
}


}

 * */
