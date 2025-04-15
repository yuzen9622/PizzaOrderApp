package com.example.pizzaorderapp

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity

class OrderSideActivity:AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_side)
        val btnFries:Button = findViewById(R.id.btn_fries)
        val btnSalad:Button = findViewById(R.id.btn_salad)
        btnFries.setOnClickListener{
            val intent=Intent()
            intent.putExtra("side_order","薯條")
            setResult(RESULT_OK,intent)
            finish()
        }
        btnSalad.setOnClickListener{
            val intent=Intent()
            intent.putExtra("side_order","沙拉")
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}