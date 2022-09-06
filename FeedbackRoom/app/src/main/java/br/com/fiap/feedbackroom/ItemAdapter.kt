package br.com.fiap.feedbackroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.feedbackroom.database.Carro

class ItemAdapter (private val dataSet: List<Carro>): RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textView1: TextView
        val textView2: TextView
        val textView3: TextView

        init {
            textView1 = view.findViewById(R.id.TxtVNome)
            textView2 = view.findViewById(R.id.TxtVAno)
            textView3 = view.findViewById(R.id.TxtVFabricante)

        }
    }

    //Define o layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.recyclerview_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val carro = dataSet[position]
        holder.textView1.text = carro.modelo
        holder.textView2.text = carro.ano
        holder.textView3.text = carro.fabricante


    }

    //Retorna o tamanho da lista
    override fun getItemCount(): Int {
        return dataSet.size
    }
}