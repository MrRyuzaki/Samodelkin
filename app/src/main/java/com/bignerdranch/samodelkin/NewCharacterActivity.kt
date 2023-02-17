package com.bignerdranch.samodelkin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bignerdranch.samodelkin.databinding.ActivityNewCharacterBinding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewbinding.ViewBinding

private lateinit var binding: ActivityNewCharacterBinding
class NewCharacterActivity : AppCompatActivity() {
    private var characterData = CharacterGenerator.generate()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewCharacterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.run {
            generateButton.setOnClickListener{
                characterData = CharacterGenerator.generate()
                displayCharacterData()
            }
        }
    }
        private fun displayCharacterData() {
        characterData.run {
                binding.nameTextView.text = name
                binding.raceTextView.text = race
                binding.dexterityTextView.text = dex
                binding.wisdomTextView.text = wis
                binding.strengthTextView.text = str
        }
    }
}