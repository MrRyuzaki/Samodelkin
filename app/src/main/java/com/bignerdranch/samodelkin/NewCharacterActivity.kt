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
private const val CHARACTER_DATA_KEY = "CHARACTER_DATA_KEY"

class NewCharacterActivity : AppCompatActivity() {
    private var characterData = CharacterGenerator.generate()

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(CHARACTER_DATA_KEY, characterData)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewCharacterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        characterData = savedInstanceState?.let {
            it.getSerializable(CHARACTER_DATA_KEY) as CharacterGenerator.CharacterData
        } ?: CharacterGenerator.generate()

        binding.run {
            generateButton.setOnClickListener{
                characterData = CharacterGenerator.generate()
                displayCharacterData()
            }
        }
        displayCharacterData()
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