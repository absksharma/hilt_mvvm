package com.ab.hilt_kt.ui.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ab.hilt_kt.databinding.ActivityMainBinding
import com.ab.hilt_kt.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        vm = ViewModelProvider(this@MainActivity)[MainViewModel::class.java]

        vm.fetchDogs()
        setContentView(binding.root)

        vm.list.observe(this) {
            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
        }
    }
}