package com.example.loteria

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnGerar: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGerar = findViewById(R.id.btnGerar)
        txtResultado = findViewById(R.id.txtResultado)

        btnGerar.setOnClickListener {
            val numeros = (0..100).toMutableList()
            numeros.shuffle()
            val aleatorios = numeros.take(10).sorted()

            txtResultado.text = "Seus números da sorte são:\n${aleatorios.joinToString(", ")}"
        }
    }
}
