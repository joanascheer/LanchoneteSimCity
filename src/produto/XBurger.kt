package produto

import sistema.Sistema

class XBurger(
    override var tipoDeProduto: String = "X-burguer",
    override var codigo: Int = 0,
    override var preco: Double = 12.0,
    override var quantidade: Int = 0,
) : Lanche(tipoDeProduto, codigo) {

    fun criaXBurger(sistema: Sistema) {
        val xBurger = XBurger()
        xBurger.pegaQuantidadeXBurger()
        sistema.adicionaProdutoCarrinho(xBurger)
    }

    private fun pegaQuantidadeXBurger(): Int {
        println("Quantos $tipoDeProduto você deseja comprar?")
        quantidade = readln().toInt()
        return quantidade
    }

    private fun calculaTotalXBurger(xBurger: XBurger): Double {
        println("Até o momento,")
        return quantidade * preco
    }


}

