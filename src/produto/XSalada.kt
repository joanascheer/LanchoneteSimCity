package produto

import sistema.Sistema
import utilities.Utilities

class XSalada(
    override var codigo: Int = 0,
    override var tipoDeProduto: String = "X-Salada",
    override var preco: Double = 12.0,
    override var quantidade: Int = 0,
) : Lanche(tipoDeProduto, codigo) {

    internal fun criaXSalada(sistema: Sistema) {
        val xSalada = XSalada()
        xSalada.pegaQuantidadeXSalada()
        sistema.adicionaProdutoCarrinho(xSalada)
    }

    internal fun pegaQuantidadeXSalada(): Int {
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
            pegaQuantidadeXSalada()
        }
        return quantidade
    }

}

