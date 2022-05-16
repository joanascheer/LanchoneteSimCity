package produto

import sistema.Sistema

class XBurger(
    override var tipoDeProduto: String = "X-Burguer",
    override var codigo: Int = 0,
    override var preco: Double = 10.0,
    override var quantidade: Int = 0,
) : Lanche(tipoDeProduto, codigo) {

    fun criaXBurger(sistema: Sistema) {
        val xBurger = XBurger()
        xBurger.pegaQuantidadeXBurger()
        sistema.adicionaProdutoCarrinho(xBurger)
    }

    fun pegaQuantidadeXBurger(): Int {
        println("Quantos $tipoDeProduto você deseja comprar?")
        quantidade = readln().toInt()
        return quantidade
    }

}

