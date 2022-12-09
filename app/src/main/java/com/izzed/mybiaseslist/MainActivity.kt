package com.izzed.mybiaseslist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBiases : RecyclerView
    private var list : ArrayList<Bias> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        rvBiases = findViewById(R.id.rv_biases)
        rvBiases.setHasFixedSize(true)

        list.addAll(BiasesData.listData)
        showRecyclerList()

        val btnAboutPage = findViewById<ImageButton>(R.id.about_page)
        btnAboutPage.setOnClickListener {
            val about = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(about)
        }
    }

    private fun showRecyclerList() {
        rvBiases.layoutManager = LinearLayoutManager(this)
        val listBiasAdapter = ListBiasAdapter(list)
        rvBiases.adapter = listBiasAdapter

        listBiasAdapter.setOnItemClickCallback(object : ListBiasAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Bias) {
                val listDataBias = Bias(
                    data.name,
                    data.real_name,
                    data.birthdate,
                    data.height,
                    data.blood_type,
                    data.zodiac,
                    data.detail,
                    data.photo
                )
                val detail = Intent(this@MainActivity, DetailActivity::class.java)
                detail.putExtra(DetailActivity.EXTRA_DATA, listDataBias)
                startActivity(detail)
            }
        })
    }
}