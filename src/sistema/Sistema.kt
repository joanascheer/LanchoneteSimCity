package sistema

import produto.*
import utilities.Utilities.Utilities.sair
import utilities.Utilities.Utilities.sucesso

class Sistema {
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
                        "Valor total dos produtos escolhidos: ${calcula(produto.quantidade, produto.preco)}")
            }
        }
        calculaValorTotal()
    }

    private fun calcula(quantidade: Int, preco: Double): Double {
        return preco * quantidade
    }

    fun calculaValorTotal(): Double {
        var totalFinal = 0.0
        carrinhoDeCompras.forEach { (_, produto) ->
            totalFinal += calcula(produto.quantidade, produto.preco)
        }

        println("************************************\n" +
                "Valor total do carrinho: $totalFinal\n")
        return totalFinal
    }

    fun calculaTroco(totalFinal: Double) {
        println("Qual o valor em dinheiro você vai usar para pagar sua compra?")
        val valorInformado = readln().toDouble()

        if (valorInformado < totalFinal) {
            println("Este valor não é o suficiente para pagar as suas compras.")
            calculaTroco(totalFinal)
        }
        val troco = valorInformado - totalFinal
        println("Devolvendo $troco de troco. Obrigado(a) pela compra!")
    }

    fun removeItem() {
        println("Digite o código do produto que deseja excluir do carrinho")
        val codigo = readln().toInt()

        if (codigo in carrinhoDeCompras) {
            carrinhoDeCompras.remove(codigo)
            sucesso()
            mostraCarrinhoDeCompras()
        } else {
            println("Não existe um produto com este código no seu carrinho.\n")
        }
    }

    fun editarItem() {
        println("Digite o código do produto que deseja alterar")
        val codigo = readln().toInt()

        if (codigo in carrinhoDeCompras) {

            println("Que produto deseja escolher no lugar?\n" +
                    "[1] X-Burger\n" +
                    "[2] X-Salada\n" +
                    "[3] Refrigerante\n" +
                    "[4] Suco\n" +
                    "[5] Desistir da compra")
            when (readln().toInt()) {
                1 -> {
                    val novoProduto = XBurger()
                    novoProduto.pegaQuantidadeXBurger()
                    carrinhoDeCompras[codigo] = novoProduto
                    mostraCarrinhoDeCompras()
                }
                2 -> {
                    val novoProduto = XSalada()
                    novoProduto.pegaQuantidadeXSalada()
                    carrinhoDeCompras[codigo] = novoProduto
                    mostraCarrinhoDeCompras()
                }
                3 -> {
                    val novoProduto = Refrigerante()
                    novoProduto.pegaQuantidadeRefrigerante()
                    carrinhoDeCompras[codigo] = novoProduto
                    mostraCarrinhoDeCompras()
                }
                4 -> {
                    val novoProduto = Suco()
                    novoProduto.pegaQuantidadeSuco()
                    carrinhoDeCompras[codigo] = novoProduto
                    mostraCarrinhoDeCompras()
                }
                5 -> sair()

            }

            println("*********************************************************")
            mostraCarrinhoDeCompras()

        }
    }


}