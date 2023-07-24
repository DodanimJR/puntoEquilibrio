package com.example.myapplication

import android.app.Activity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflar la vista utilizando View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar el OnClickListener del botón "Calcular"
        binding.calculateButton.setOnClickListener {
            calculateEquilibriumPoint()
        }
    }

    // Función para calcular el punto de equilibrio
    private fun calculateEquilibriumPoint() {
        // Obtener los valores ingresados en los EditText y convertirlos a Double
        val revenue = binding.editTextRevenue.text.toString().toDoubleOrNull() ?: 0.0
        val totalCost = binding.editTextCost.text.toString().toDoubleOrNull() ?: 0.0
        val fixedCost = binding.editTextFixedCost.text.toString().toDoubleOrNull() ?: 0.0

        // Calcular el punto de equilibrio utilizando la fórmula: Costos Fijos / (Ingresos - Costos Totales)
        val equilibriumPoint: Double = if (totalCost != 0.0) {
            fixedCost / (revenue - totalCost)
        } else {
            0.0
        }

        // Mostrar el resultado en el TextView de resultado
        binding.resultTextView.text = "Resultado: $equilibriumPoint"

        // Reiniciar los EditText a sus valores iniciales
        binding.editTextRevenue.text.clear()
        binding.editTextCost.text.clear()
        binding.editTextFixedCost.text.clear()
    }
}

