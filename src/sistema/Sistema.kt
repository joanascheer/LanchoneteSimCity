package sistema

import produto.*

class Sistema() {
    private val listaProdutos = ArrayList<Produto>()
    private val carrinhoDeCompras = mutableMapOf<Int, Produto>()

    private var codigo = 100

    private fun geraCodigoProduto(produto: Produto): Int {
        codigo += 1
        carrinhoDeCompras[codigo] = produto
        return codigo
    }

    fun adicionaProdutoCarrinho(produto: Produto) {
        geraCodigoProduto(produto)
        mostraCarrinhoDeCompras()
    }

    private fun mostraCarrinhoDeCompras() {
        if (carrinhoDeCompras.isEmpty()) {
            println("Seu carrinho está vazio, adicione produtos para continuar.")
        } else {
            println("*** Seu carrinho de compras ***\n")
            carrinhoDeCompras.forEach { (chave, produto) ->
                println("Código: $chave\n" +
                        "Tipo de produto: ${produto.tipoDeProduto}\n" +
                        "Valor unitário: ${produto.preco}\n" +
                        "Quantidade: ${produto.quantidade}\n" +
                        "Valor total dos produtos escolhidos: ${calcula(produto.quantidade,produto.preco)}")
            }
        }
        calculaValorTotal()
    }

    private fun calcula(quantidade: Int, preco: Double): Double {
        return preco * quantidade
    }

    private fun calculaValorTotal(): Double {
        var totalFinal = 0.0
        carrinhoDeCompras.forEach { (_, produto) ->
            totalFinal += calcula(produto.quantidade, produto.preco)
        }

        println("************************************\n" +
                "Valor total do carrinho: $totalFinal\n")
        return totalFinal
    }

//    fun calculaTroco() {
//        println("Qual o valor em dinheiro você vai usar para pagar sua compra?")
//        val valorInformado = readln().toDouble()
//        val troco = valorInformado - totalFinal
//        println("Devolvendo $troco de troco. Obrigado(a) pela compra!")
//    }

    fun removeItem() {
        println("Digite o código do produto que deseja excluir do carrinho")
        val codigo = readln().toInt()

        if (codigo in carrinhoDeCompras) {
            carrinhoDeCompras.remove(codigo)
        } else {
            println("Não existe um produto com este código no seu carrinho.\n")
        }
    }


}