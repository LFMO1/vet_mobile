package com.example.vetconnect.objects

data class Clinicas(
    val id: Int,
    val bairro: String,
    val cep: String,
    val cidade: String,
    val cnpj: String,
    val complemento: String,
    val contato: String,
    val estado: String,
    val horarioAbertura: String,
    val horarioFechamento: String,
    val nome: String,
    val rua: String,
    val numero: String
)