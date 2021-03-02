package com.brian.remvp3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import com.brian.remvp3.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var address = ""

    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListener()
        setUpClickListener()
    }

    private fun saveDataInRoom() {
        if (address.isBlank()) {
            Toast.makeText(this, "Empty data", Toast.LENGTH_SHORT).show()
        } else {
            mainActivityViewModel.saveData()
        }
    }

    private fun setUpClickListener() {
        binding.submit.setOnClickListener {
            saveDataInRoom()
        }
    }

    private fun setUpListener() {
        binding.address.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                address = s.toString()
            }
        })
    }


}