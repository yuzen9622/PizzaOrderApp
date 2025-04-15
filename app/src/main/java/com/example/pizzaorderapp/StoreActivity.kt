package com.example.pizzaorderapp


import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.net.Uri
import android.widget.BaseAdapter
import android.widget.EditText

class StoreActivity:AppCompatActivity() {
    data class StoreContact(

        val storeName:CharSequence,
        val storePhone:CharSequence
    )
    class StoreAdapter(context: Context, private  val data:ArrayList<StoreContact>, val layoutId:Int):
        ArrayAdapter<StoreContact>(context,layoutId,data){
        override fun getItem(position: Int)=data[position]
        override fun getItemId(position: Int): Long =0
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view=View.inflate(parent.context,layoutId,null)
            val item=getItem(position)?:return  view

            val nameText=view.findViewById<TextView>(R.id.store_name_text)
            val phoneText=view.findViewById<TextView>(R.id.store_phone_text)
            nameText.text=item.storeName
            phoneText.text=item.storePhone
            return  view
        }

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)
        val btnDialog:Button = findViewById(R.id.btn_store_dialog)

        val listView=findViewById<ListView>(R.id.listView)
        val items= arrayListOf<StoreContact>()


        btnDialog.setOnClickListener {
            AlertDialog.Builder(this).setView(R.layout.store_diolag)
                .setPositiveButton("OK"){dialog,which->

                   val nameInput= (dialog as AlertDialog).findViewById<TextView>(R.id.editTextText)!!.text
                    val phoneInput= (dialog as AlertDialog).findViewById<TextView>(R.id.editTextText2)!!.text
                  //  val btnPhoto:ImageButton=(dialog as AlertDialog).findViewById(R.id.image_select)
//                    var imgUri:Uri
//                    val pickImageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//                        if (result.resultCode == Activity.RESULT_OK) {
//                            val imageUri: Uri? = result.data?.data
//                            if(imageUri !=null){
//                                btnPhoto.setImageURI(imageUri)
//                                imgUri=imageUri
//                            }
//
//                        }
//                    }
//                    btnPhoto.setOnClickListener{
//                        val intent = Intent(Intent.ACTION_PICK)
//                        intent.type = "image/*"
//                        pickImageLauncher.launch(intent)
//
//                    }
                    items.add(StoreContact(nameInput,phoneInput))
                    listView.adapter=StoreAdapter(this,items,R.layout.adapter_item)

                }.show()
        }
        listView.setOnItemClickListener() { parent, view, position, id ->
            val storePhone = items[position].storePhone
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$storePhone")
            startActivity(intent)

        }
        listView.setOnItemLongClickListener(){parent,view,position,id->
            val store = items[position]
            val dialogView = layoutInflater.inflate(R.layout.store_diolag, null)
            val editName = dialogView.findViewById<EditText>(R.id.editTextText)
            val editPhone = dialogView.findViewById<EditText>(R.id.editTextText2)

            // 把原本的資料放進去
            editName.setText(store.storeName)
            editPhone.setText(store.storePhone)
            AlertDialog.Builder(this).setView(dialogView)
                .setPositiveButton("儲存") { _, _ ->
                    val newName = editName.text.toString()
                    val newPhone = editPhone.text.toString()

                    // 修改原本的資料
                    items[position] = StoreContact(newName, newPhone)

                    // 通知 adapter 資料更新（假設你是用 custom adapter）
                    (listView.adapter as BaseAdapter).notifyDataSetChanged()
                }
                .setNegativeButton("取消", null).show()
        true
        }
        
    }
}