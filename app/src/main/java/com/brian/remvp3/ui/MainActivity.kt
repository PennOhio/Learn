package com.brian.remvp3.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.brian.remvp3.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.StringBuilder

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var address = ""

    private var numberOne = ""

    private var numberTwo = ""

    private val mainActivityViewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpListener()
        setUpClickListener()
        observeLiveData()
    }

    private fun observeLiveData() {
        mainActivityViewModel.getPropertyListLiveData()
            .observe(this, Observer { propertyList ->
                propertyList?.let {
                    val stringBuilder = StringBuilder()
                    it.forEach { property ->
                        stringBuilder.append(property.address)
                        stringBuilder.append("\n")
                    }
                    binding.displayAddress.text = stringBuilder.toString()
                }
            })
    }

    private fun saveDataInRoom() {
        if (address.isBlank() || numberOne.isBlank() || numberTwo.isBlank()) {
            Toast.makeText(this, "Empty data", Toast.LENGTH_SHORT).show()
        } else {
            mainActivityViewModel.saveData(address, numberOne.toInt(), numberTwo.toInt())
            binding.address.setText("")
            binding.numberOne.setText("")
            binding.numberTwo.setText("")

        }
    }

    private fun getAddressFromDB() {
        mainActivityViewModel.getAll()
    }

    private fun setUpClickListener() {
        binding.submit.setOnClickListener {
            saveDataInRoom()
        }

        binding.getAddress.setOnClickListener {
            getAddressFromDB()
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

        binding.numberOne.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                numberOne = s.toString()
            }
        })

        binding.numberTwo.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable) {
                numberTwo = s.toString()
            }
        })
    }




}