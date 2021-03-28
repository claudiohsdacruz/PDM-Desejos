package com.example.listadedesejos

import java.io.Serializable

var QTDE =0
class Desejo: Serializable {
    var id : Int
    var descricao: String
    var valor: Float
    constructor(descricao: String, valor: Float){
        this.id = ++QTDE
        this.descricao = descricao
        this.valor = valor
    }
    override fun toString(): String {
        return "${this.id} - ${this.descricao} - R$ ${this.valor}"
    }
}