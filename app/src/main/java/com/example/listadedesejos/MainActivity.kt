package com.example.listadedesejos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var lvDesejos : ListView
    private lateinit var btAdd : FloatingActionButton
    private lateinit var lista : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lvDesejos = findViewById(R.id.lvDesejos)
        this.btAdd = findViewById(R.id.btAdd)

        this.lista = ArrayList()
        var layout = android.R.layout.simple_list_item_1
        this.lvDesejos.adapter = ArrayAdapter<String>(this,layout,this.lista)

        this.btAdd.setOnClickListener( {addDesejo (it)})

    }

    private fun addDesejo (view: View) {
        val intent = Intent(this,OutraActivity::class.java)
        startActivityForResult(intent,1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 1){
                val msg = data?.getSerializableExtra("DESEJO") as Desejo
                //val desejo: Desejo = intent.getSerializableExtra("DESEJO") as Desejo
                val elemento = "${msg.descricao} - R$ ${msg.valor}"
                (this.lvDesejos.adapter as ArrayAdapter<String>).add(elemento)
            }
        }
    }

}