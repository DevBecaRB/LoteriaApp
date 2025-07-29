package com.example.loteria

import androidx.activity.viewModels
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.loteria.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObservers(binding)
        setupListeners(binding)
    }

    private fun setupObservers(binding: ActivityMainBinding) {
        viewModel.numerosSorte.observe(this) { numeros ->
            val texto = "Seus números da sorte são:\n${numeros.joinToString(", ")}"
            binding.txtResultado.text = texto
        }
    }

    private fun setupListeners(binding: ActivityMainBinding) {
        binding.btnGerar.setOnClickListener {
            viewModel.gerarNumeros()
        }
    }
}

