package produto

import sistema.Sistema

class Suco(
    override var codigo: Int = 0,
    override var tipoDeProduto: String = "Suco",
    override var preco: Double = 6.0,
    override var quantidade: Int = 0,
) : Bebida(tipoDeProduto,codigo) {

    fun criaSuco(sistema: Sistema) {
        val suco = Suco()
        suco.pegaQuantidadeSuco()
        sistema.adicionaProdutoCarrinho(suco)
    }

    internal fun pegaQuantidadeSuco(): Int {
        println("Quantos ${tipoDeProduto}s você deseja comprar?")
        quantidade = readln().toInt()
        return quantidade
    }

}