package com.bams.plasticman_superhero

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bams.plasticman_superhero.databinding.ActivityMainBinding
import com.bams.plasticman_superhero.viewmodel.SuperheroViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: SuperheroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val accessToken = "ad2611e56714470756c0d9b96e5594fb"
        val superheroId = 520

        viewModel.fetchSuperhero(accessToken, superheroId)

        viewModel.superhero.observe(this, Observer { superhero ->
            if (superhero != null) {
                Log.d("MainActivity", "Superhero data received: $superhero")
                val imageView: ImageView = binding.root.findViewById(R.id.ivSuperheroImage)
                Glide.with(this)
                    .load(superhero.image.url)
                    .into(imageView)
                binding.biographyCard.findViewById<TextView>(R.id.tvFullName).text = "Full Name: ${superhero.biography.fullName}"
                binding.biographyCard.findViewById<TextView>(R.id.tvFirstAppearance).text = "First Appearance: ${superhero.biography.firstAppearance}"
                binding.biographyCard.findViewById<TextView>(R.id.tvAlignment).text = "Alignment: ${superhero.biography.alignment}"
                binding.biographyCard.findViewById<TextView>(R.id.tvRelatives).text = "Relatives: ${superhero.connections.relatives}"
                binding.biographyCard.findViewById<TextView>(R.id.tvGroup).text = "Publisher: ${superhero.connections.groupaffiliation}"
                binding.powerstatsCard.findViewById<TextView>(R.id.tvIntelligence).text = "Intelligence: ${superhero.powerstats.intelligence}"
                binding.powerstatsCard.findViewById<TextView>(R.id.tvStrength).text = "Strength: ${superhero.powerstats.strength}"
                binding.powerstatsCard.findViewById<TextView>(R.id.tvPower).text = "Power: ${superhero.powerstats.power}"
                binding.powerstatsCard.findViewById<TextView>(R.id.tvDurability).text = "Durability: ${superhero.powerstats.durability}"
                binding.powerstatsCard.findViewById<TextView>(R.id.tvSpeed).text = "Speed: ${superhero.powerstats.speed}"
                binding.powerstatsCard.findViewById<TextView>(R.id.tvCombat).text = "Combat: ${superhero.powerstats.combat}"
            } else {
                Log.d("MainActivity", "No superhero data received")
            }
        })
    }
}



