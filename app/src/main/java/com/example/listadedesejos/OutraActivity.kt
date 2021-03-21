package com.example.listadedesejos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class OutraActivity : AppCompatActivity() {
    private lateinit var etDesejo: EditText
    private lateinit var etValor: EditText
    private lateinit var btCadastrar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        this.etDesejo = findViewById(R.id.etDesejo)
        this.etValor = findViewById(R.id.etValor)

        this.btCadastrar = findViewById(R.id.btCadastrar)
        this.btCadastrar.setOnClickListener( {cadastrar(it)} )

        this.btCancelar = findViewById(R.id.btCancelar)
        this.btCancelar.setOnClickListener( {cancelar (it)})

    }

    private fun cadastrar(view: View) {
        val nome: String = this.etDesejo.text.toString()
        val valor = this.etValor.text.toString().toFloat()

        val desejo = Desejo(nome,valor)

        val intent = Intent(this,MainActivity::class.java)
        intent.putExtra("DESEJO",desejo)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    private fun cancelar(view: View) {
       finish()
    }
}