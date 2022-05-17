package produto

import sistema.Sistema
import utilities.Utilities

class XBurger(
    override var tipoDeProduto: String = "X-Burguer",
    override var codigo: Int = 0,
    override var preco: Double = 10.0,
    override var quantidade: Int = 0,
) : Lanche(tipoDeProduto, codigo) {

    internal fun criaXBurger(sistema: Sistema) {
        val xBurger = XBurger()
        xBurger.pegaQuantidadeXBurger()
        sistema.adicionaProdutoCarrinho(xBurger)
    }

    internal fun pegaQuantidadeXBurger(): Int {
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
            pegaQuantidadeXBurger()
        }
        return quantidade
    }

}

