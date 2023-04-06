package com.example.imenik.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.imenik.MainActivity
import com.example.imenik.MainActivityViewModel
import com.example.imenik.databinding.ActivityNewContactBinding
import com.example.imenik.model.Imenik

class NewContact : AppCompatActivity() {
    lateinit var binding:ActivityNewContactBinding
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application))[MainActivityViewModel::class.java]


        binding.btnSave.setOnClickListener{

            val imenik = Imenik(name = binding.txtImePrezime.text.toString(), phone = binding.txtPhoneNum.text.toString())
            viewModel.insertContact(imenik)
            Toast.makeText(this, "Uspjesno spremljeno", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}