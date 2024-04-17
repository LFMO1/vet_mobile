package com.example.vetconnect.requests.interfaces

import com.example.vetconnect.objects.Clinicas
import retrofit2.Call
import retrofit2.http.GET

interface Gets {

    @GET("api/unidade/v1/somente-unidades")
    fun getClinicas() : Call<List<Clinicas>>
}