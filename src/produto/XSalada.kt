package produto

import sistema.Sistema

class XSalada(
    override var codigo: Int = 0,
    override var tipoDeProduto: String = "X-Salada",
    override var preco: Double = 12.0,
    override var quantidade: Int = 0,
) : Lanche(tipoDeProduto, codigo) {

    fun criaXSalada(sistema: Sistema) {
        val xSalada = XSalada()
        xSalada.pegaQuantidadeXSalada()
        sistema.adicionaProdutoCarrinho(xSalada)
    }

    internal fun pegaQuantidadeXSalada(): Int {
        println("Quantos $tipoDeProduto você deseja comprar?")
        quantidade = readln().toInt()
        return quantidade
    }

}

