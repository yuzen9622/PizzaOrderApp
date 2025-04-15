package com.example.pizzaorderapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class OrderPizzaActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_pizza)
        val btnPepperoni: Button =  findViewById(R.id.btn_pepperoni)
        val btnMargherita: Button = findViewById((R.id.btn_margherita))
        // 監聽器
        btnPepperoni.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("pizza_order", "Pepperoni Pizza")
            setResult(RESULT_OK, resultIntent)
            finish()

        }

        btnMargherita.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("pizza_order", "Margherita Pizza")
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}