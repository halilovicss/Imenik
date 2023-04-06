package com.example.imenik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.SearchView
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.imenik.adapter.ImenikAdapter
import com.example.imenik.databinding.ActivityMainBinding
import com.example.imenik.screens.NewContact


class MainActivity : AppCompatActivity(),LifecycleObserver {



    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    lateinit var adapter: ImenikAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application))[MainActivityViewModel::class.java]

        viewModel.allContacts.observe(this) {list ->
            list.let {

                adapter = ImenikAdapter(it)
                binding.rvList.adapter = adapter

            }
        }



        }

    private fun initUI() {

        binding.rvList.setHasFixedSize(true)
        binding.rvList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        binding.imgAdd.setOnClickListener {
            startActivity(Intent(this,NewContact::class.java))
        }


    }



    }




