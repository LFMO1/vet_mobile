package com.example.vetconnect.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vetconnect.R
import com.example.vetconnect.adapters.ClinicaAdapter
import com.example.vetconnect.objects.Clinicas
import com.example.vetconnect.requests.interfaces.Gets
import com.example.vetconnect.requests.utils.NetworkUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ClinicasFragment : Fragment() {

    private lateinit var clinicaAdapter: ClinicaAdapter
    private lateinit var  recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view =  inflater.inflate(R.layout.fragment_clinica, container, false)
        recyclerView = view.findViewById<RecyclerView>(R.id.rvClinica)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())



        val clinicasList : ArrayList<Clinicas> = ArrayList()
        val retrofitClient = NetworkUtils.getRetrofitInstance("https://192.168.18.9:9191")
        val endpoint = retrofitClient.create(Gets::class.java)
        val callback = endpoint.getClinicas()

        callback.enqueue(object : Callback<List<Clinicas>> {
            override fun onFailure(call: Call<List<Clinicas>>, t: Throwable) {
                AlertDialog.Builder(requireContext()).setMessage(t.message).create().show()
            }

            override fun onResponse(
                call: Call<List<Clinicas>>,
                response: Response<List<Clinicas>>
            ) {
                if(response.isSuccessful){
                    response.body()?.let{
                        clinicasList.addAll(it)
                    }
                }else{
                    AlertDialog.Builder(requireContext()).setMessage(response.message()).create().show()
                }


            }
        })

//             var  clinicasList = listOf(
//            Clinicas(
//                id = 1,
//                bairro = "Centro",
//                cep = "12345-678",
//                cidade = "São Paulo",
//                cnpj = "12.345.678/0001-90",
//                complemento = "Sala 101",
//                contato = "(11) 1234-5678",
//                estado = "SP",
//                horarioAbertura = "08:00",
//                horarioFechamento = "18:00",
//                nome = "Clínica A",
//                rua = "Rua Principal",
//                numero = "123"
//            ),
//            Clinicas(
//                id = 2,
//                bairro = "Bairro Novo",
//                cep = "54321-098",
//                cidade = "Rio de Janeiro",
//                cnpj = "98.765.432/0001-21",
//                complemento = "Sala 202",
//                contato = "(21) 9876-5432",
//                estado = "RJ",
//                horarioAbertura = "09:00",
//                horarioFechamento = "19:00",
//                nome = "Clínica B",
//                rua = "Avenida Secundária",
//                numero = "456"
//            ),
//            Clinicas(
//                id = 3,
//                bairro = "Vila Nova",
//                cep = "67890-123",
//                cidade = "Belo Horizonte",
//                cnpj = "33.333.333/0001-33",
//                complemento = "Sala 303",
//                contato = "(31) 3333-3333",
//                estado = "MG",
//                horarioAbertura = "07:30",
//                horarioFechamento = "17:30",
//                nome = "Clínica C",
//                rua = "Rua da Esquina",
//                numero = "789"
//            )
//        )



        clinicaAdapter = ClinicaAdapter(requireContext(), clinicasList)
        recyclerView.adapter = clinicaAdapter


        return view
    }


}

