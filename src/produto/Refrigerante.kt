package produto

import sistema.Sistema
import utilities.Utilities.Utilities.opcaoInvalida

class Refrigerante (
    override var codigo: Int = 0,
    override var tipoDeProduto: String = "Refrigerante",
    override var preco: Double = 8.0,
    override var quantidade: Int = 0,
    ) : Bebida(tipoDeProduto,codigo) {

    internal fun criaRefrigerante(sistema: Sistema) {

        val refrigerante = Refrigerante()
        refrigerante.pegaQuantidadeRefrigerante()
        sistema.adicionaProdutoCarrinho(refrigerante)
    }

    internal fun pegaQuantidadeRefrigerante(): Int {
        try {
            println("Quantos ${tipoDeProduto}s você deseja comprar?")
            quantidade = readln().toInt()
            if (quantidade <= 0) {
                throw IllegalArgumentException()
            } else {
                return quantidade
            }

        } catch (e: Exception) {
            opcaoInvalida()
            pegaQuantidadeRefrigerante()
        }
        return quantidade
    }

    }