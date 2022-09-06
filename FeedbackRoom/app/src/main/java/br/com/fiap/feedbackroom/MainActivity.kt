package br.com.fiap.feedbackroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.feedbackroom.database.AppCarsDatabase
import br.com.fiap.feedbackroom.database.Carro
import br.com.fiap.feedbackroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Carrega o recyclerview
        load()

        //Abre activity do formulário
        binding.buttonForm.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
        }
    }

    private fun load() {
        val recyclerView = binding.recyclerView
        val view = binding.root
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        val appDb = AppCarsDatabase.getDatabase(view.context);
        var carro = appDb.CarroDao().getAll();
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = ItemAdapter(carro)

        val itemDecor = DividerItemDecoration(binding.root.context, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(itemDecor)
    }

    override fun onResume() {
        super.onResume()
        load()
    }
}