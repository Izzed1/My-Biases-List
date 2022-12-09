package com.izzed.mybiaseslist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatDelegate
import com.izzed.mybiaseslist.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        var EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val listBias = intent.getParcelableExtra<Bias>(EXTRA_DATA) as Bias
        listBias.photo?.let { binding.mainPhoto.setImageResource(it) }
        binding.tvName.text = listBias.name
        binding.tvRealName.text = listBias.real_name
        binding.tvBirthdate.text = listBias.birthdate
        binding.tvHeight.text = listBias.height
        binding.tvBlood.text = listBias.blood_type
        binding.tvZodiac.text = listBias.zodiac
        binding.tvDescription.text = listBias.detail

        val btnPrevious = findViewById<ImageButton>(R.id.btn_previous)
        btnPrevious.setOnClickListener {
            val previous = Intent(this@DetailActivity, MainActivity::class.java)
            startActivity(previous)
        }

    }
}