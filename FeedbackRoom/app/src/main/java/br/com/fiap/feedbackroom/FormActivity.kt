package br.com.fiap.feedbackroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.fiap.feedbackroom.database.AppCarsDatabase
import br.com.fiap.feedbackroom.database.Carro
import br.com.fiap.feedbackroom.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val view = binding.root
        val appDb = AppCarsDatabase.getDatabase(view.context)

        binding.buttonSalvar.setOnClickListener {
            if(validarCamposObrigatorios(view)){
                Toast.makeText(view.context, R.string.registro_cadastrado_com_sucesso, Toast.LENGTH_LONG).show()
                val modelo = binding.editTModelo.text.toString()
                val fabricante = binding.editTCompany.text.toString()
                val placa = binding.editTPlaca.text.toString()
                val preco = binding.editTPrice.text.toString()
                val ano = binding.editTAno.text.toString()
                val novoCarro = Carro(0, modelo, fabricante, placa, preco, ano)
                appDb.CarroDao().insert(novoCarro)

                //Limpa o formulário
                binding.editTModelo.setText(R.string.vazio)
                binding.editTCompany.setText(R.string.vazio)
                binding.editTPlaca.setText(R.string.vazio)
                binding.editTPrice.setText(R.string.vazio)
                binding.editTAno.setText(R.string.vazio)
                finish()
            }
        }


    }

    fun validarCamposObrigatorios(view: LinearLayout): Boolean{
        if(binding.editTModelo.text.isNullOrEmpty() || binding.editTAno.text.isNullOrEmpty()) {
            Toast.makeText(view.context, R.string.campo_e_obrigatorio, Toast.LENGTH_LONG)
                .show()
            binding.editTModelo.requestFocus()
            return false
        }
        return true
    }
}






