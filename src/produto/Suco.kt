package produto

import sistema.Sistema
import utilities.Utilities

class Suco(
    override var codigo: Int = 0,
    override var tipoDeProduto: String = "Suco",
    override var preco: Double = 6.0,
    override var quantidade: Int = 0,
) : Bebida(tipoDeProduto, codigo) {

    internal fun criaSuco(sistema: Sistema) {
        val suco = Suco()
        suco.pegaQuantidadeSuco()
        sistema.adicionaProdutoCarrinho(suco)
    }

    internal fun pegaQuantidadeSuco(): Int {
        try {
            println("Quantos ${tipoDeProduto}s você deseja comprar?")
            quantidade = readln().toInt()
            if (quantidade <= 0) {
                throw IllegalArgumentException()
            } else {
                return quantidade
            }

        } catch (e: Exception) {
            Utilities.opcaoInvalida()
            pegaQuantidadeSuco()
        }
        return quantidade
    }

}