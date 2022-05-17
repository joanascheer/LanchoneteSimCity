package sistema

import produto.*
import utilities.Utilities.Utilities.digitarCodigo
import utilities.Utilities.Utilities.numeroNegativo
import utilities.Utilities.Utilities.opcaoInvalida
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

    internal fun adicionaProdutoCarrinho(produto: Produto) {
        geraCodigoProduto(produto)
        mostraCarrinhoDeCompras()
    }

    fun mostraCarrinhoDeCompras() {
        if (carrinhoDeCompras.isEmpty()) {
            println("Seu carrinho está vazio, adicione produtos para continuar.")
        } else {
            println("*** Seu carrinho de compras ***\n")
            carrinhoDeCompras.forEach { (chave, produto) ->
                println("Código: $chave\n" +
                        "Tipo de produto: ${produto.tipoDeProduto}\n" +
                        "Valor unitário: ${produto.preco}\n" +
                        "Quantidade: ${produto.quantidade}\n" +
                        "Valor total dos produtos escolhidos: ${calcula(produto.quantidade, produto.preco)}\n" +
                        "***\n")
            }
        }
        calculaValorTotal()
    }

    private fun calcula(quantidade: Int, preco: Double): Double {
        return preco * quantidade
    }

    internal fun calculaValorTotal(): Double {
        var totalFinal = 0.0
        carrinhoDeCompras.forEach { (_, produto) ->
            totalFinal += calcula(produto.quantidade, produto.preco)
        }

        mostraValorFinal(totalFinal)
        return totalFinal
    }

    private fun mostraValorFinal(totalFinal: Double) {
        println("************************************\n" +
                "Valor total do carrinho: $totalFinal\n")
    }

    internal fun calculaTroco(totalFinal: Double) {
        try {
            println("Qual o valor em dinheiro você vai usar para pagar sua compra?")
            val valorInformado = readln().toDouble()

            if (valorInformado < 0.0) {
                throw IllegalArgumentException()
            } else if (valorInformado < totalFinal) {
                println("Este valor não é o suficiente para pagar as suas compras.")
                calculaTroco(totalFinal)
            } else {
                val troco = valorInformado - totalFinal
                println("Obrigado(a) pela compra!\n" +
                        "Troco devolvido: R$%.2f".format(troco))
            }
        } catch (e: IllegalArgumentException) {
            numeroNegativo()
            calculaTroco(totalFinal)
        } catch (e: NumberFormatException) {
            opcaoInvalida()
            calculaTroco(totalFinal)
        } catch (e: UnsupportedOperationException) {
            println("Você deve informar um valor para continuar.")
            calculaTroco(totalFinal)
        }


    }

    internal fun removeItem() {
        try {
            println("Digite o código do produto que deseja excluir do carrinho")
            val codigo = readln().toInt()
            if (codigo < 0) {
                throw IllegalArgumentException()
            } else {
                if (codigo in carrinhoDeCompras) {
                    carrinhoDeCompras.remove(codigo)
                    sucesso()
                    mostraCarrinhoDeCompras()
                } else {
                    println("Não existe um produto com este código no seu carrinho.\n")
                }
            }
        } catch (e: IllegalArgumentException) {
            numeroNegativo()
            removeItem()
        } catch (e: NumberFormatException) {
            opcaoInvalida()
            removeItem()
        } catch (e: UnsupportedOperationException) {
            digitarCodigo()
            removeItem()
        }

    }

    internal fun editarItem() {

        try {
            println("Digite o código do produto que deseja alterar")
            val codigo = readln().toInt()

            if (codigo < 0) {
                throw IllegalArgumentException()
            } else {
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
                        else -> throw NumberFormatException()

                    }

                    println("*********************************************************")
                    mostraCarrinhoDeCompras()

                }
            }
        } catch (e: IllegalArgumentException) {
            numeroNegativo()
            editarItem()
        } catch (e: NumberFormatException) {
            opcaoInvalida()
            editarItem()
        } catch (e: UnsupportedOperationException) {
            digitarCodigo()
            editarItem()
        }

    }


}