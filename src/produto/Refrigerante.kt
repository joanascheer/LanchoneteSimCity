package produto

import sistema.Sistema

class Refrigerante (
    override var codigo: Int = 0,
    override var tipoDeProduto: String = "Refrigerante",
    override var preco: Double = 8.0,
    override var quantidade: Int = 0,
    ) : Bebida(tipoDeProduto,codigo) {

    fun criaRefrigerante(sistema: Sistema) {
        val refrigerante = Refrigerante()
        refrigerante.pegaQuantidadeRefrigerante()
        sistema.adicionaProdutoCarrinho(refrigerante)
    }

    internal fun pegaQuantidadeRefrigerante(): Int {
        println("Quantos ${tipoDeProduto}s você deseja comprar?")
        quantidade = readln().toInt()
        return quantidade
    }

    }