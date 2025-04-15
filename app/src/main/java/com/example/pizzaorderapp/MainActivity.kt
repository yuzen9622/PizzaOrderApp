package com.example.pizzaorderapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    private var pizzaOrder: String = ""
    private var sideOrder: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val pizzaLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val pizzaData = result.data?.getStringExtra("pizza_order") ?: "無"
                pizzaOrder = pizzaData
                updateSummary()
            }
        }

      val  sideLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val sideData = result.data?.getStringExtra("side_order") ?: "無"
                sideOrder = sideData
                updateSummary()
            }
        }
        val btnOrderPizza: Button = findViewById(R.id.btn_order_pizza)
        val btnOrderSide: Button = findViewById(R.id.btn_order_side)
        val btnStoreInfo: Button = findViewById(R.id.btn_store_info)

        btnOrderPizza.setOnClickListener {
            val intent = Intent(this, OrderPizzaActivity::class.java)
            pizzaLauncher.launch(intent)
        }

        btnOrderSide.setOnClickListener {
            val intent = Intent(this, OrderSideActivity::class.java)
            sideLauncher.launch(intent)
        }

        btnStoreInfo.setOnClickListener {
            val intent = Intent(this, StoreActivity::class.java)
            startActivity(intent)
        }

        updateSummary()
    }


    private fun updateSummary() {
        val summary = """
            您的訂單：
            主餐：${if (pizzaOrder.isEmpty()) "無" else pizzaOrder}
            副餐：${if (sideOrder.isEmpty()) "無" else sideOrder}
        """.trimIndent()
        findViewById<TextView>(R.id.tv_order_summary).text = summary
    }
}
