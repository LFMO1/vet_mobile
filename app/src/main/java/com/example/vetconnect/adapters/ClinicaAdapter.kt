package com.example.vetconnect.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.vetconnect.objects.Clinicas

import androidx.recyclerview.widget.RecyclerView
import com.example.vetconnect.R

class ClinicaAdapter(private val context: Context, private val clinicas: List<Clinicas>) : RecyclerView.Adapter<ClinicaAdapter.ClinicaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinicaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itens, parent, false)
        return ClinicaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return clinicas.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ClinicaViewHolder, position: Int) {
        val clinica = clinicas[position]
        holder.txtContato.text = clinica.contato
        holder.txtNome.text = clinica.nome
        holder.txtEndereco.text = clinica.rua + clinica.bairro + clinica.numero
        holder.txtHorarioFuncionamento.text =
            "${clinica.horarioAbertura} - ${clinica.horarioFechamento}"
        holder.consClinica.setOnClickListener {
            Toast.makeText(context, position.toString(), Toast.LENGTH_LONG).show()
        }
    }

    class ClinicaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNome: TextView = itemView.findViewById(R.id.txtNome)
        val txtEndereco: TextView = itemView.findViewById(R.id.txtEndereco)
        val txtHorarioFuncionamento: TextView = itemView.findViewById(R.id.txtHorarioFuncionamento)
        val txtContato: TextView = itemView.findViewById(R.id.txtContato)
        val consClinica: ConstraintLayout = itemView.findViewById(R.id.consClinica)
    }

}
