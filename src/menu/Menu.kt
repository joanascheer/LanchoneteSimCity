package menu

import produto.Refrigerante
import produto.Suco
import produto.XBurger
import produto.XSalada
import sistema.Sistema
import utilities.Utilities.Utilities.boasVindas
import utilities.Utilities.Utilities.formatoInvalido
import utilities.Utilities.Utilities.opcaoInvalida
import utilities.Utilities.Utilities.sair

class Menu {
    init {
        boasVindas()

        val sistema = Sistema()
        menuInicial(sistema)
    }

    private fun menuInicial(sistema: Sistema) {
        try {
            println("Você deseja comprar:\n" +
                    "[1] Lanche\n" +
                    "[2] Bebida\n" +
                    "[3] Desejo sair do sistema")
            when(readln().toInt()) {
                1 -> menuLanche(sistema)
                2 -> menuBebida(sistema)
                3 -> sair()
                else -> throw NumberFormatException()
            }
        }
        catch (e: NumberFormatException) {
            formatoInvalido()
            menuInicial(sistema)
        }
        catch (e: IllegalArgumentException) {
            opcaoInvalida()
            menuInicial(sistema)
        }

    }

    private fun menuLanche(sistema: Sistema) {

        try {
            println("Que lanche deseja comprar?\n" +
                    "[1] X-Burger R$10.0\n" +
                    "[2] X-Salada R$12.0\n" +
                    "[3] Sair do sistema\n")
            when(readln().toInt()) {
                1 -> {
                    val xBurger = XBurger()
                    xBurger.criaXBurger(sistema)
                    menuSecundario(sistema)
                }
                2 -> {
                    val xSalada = XSalada()
                    xSalada.criaXSalada(sistema)
                    menuSecundario(sistema)
                }
                3 -> sair()
                else -> throw NumberFormatException()
            }
        } catch (e: NumberFormatException) {
            opcaoInvalida()
            menuLanche(sistema)
        }

    }

    private fun menuBebida(sistema: Sistema) {
        try {
            println("Que bebida deseja comprar?\n" +
                    "[1] Refrigerante R$8.0\n" +
                    "[2] Suco R$6.0\n" +
                    "[3] Sair do sistema\n")
            when(readln().toInt()) {
                1 -> {
                    val refrigerante = Refrigerante()
                    refrigerante.criaRefrigerante(sistema)
                    menuSecundario(sistema)
                }
                2 -> {
                    val suco = Suco()
                    suco.criaSuco(sistema)
                    menuSecundario(sistema)
                }
                3 -> sair()
                else -> throw NumberFormatException()
            }
        } catch (e: NumberFormatException) {
            println("Opção inválida! Tente novamente.")
            menuLanche(sistema)
        } catch (e: IllegalArgumentException) {
            println("Formato inválido, para escolher o item, você deve informar o número dele.")
            menuLanche(sistema)
        }
    }

    private fun menuSecundario(sistema: Sistema) {
        try {
            println("O que deseja fazer agora?\n" +
                    "[1] Incluir mais itens\n" +
                    "[2] Editar item do carrinho de compras\n" +
                    "[3] Remover item do carrinho de compras\n" +
                    "[4] Encerrar compra\n" +
                    "[5] Sair do sistema")
            when(readln().toInt()) {
                1 -> menuInicial(sistema)
                2 -> {
                    sistema.editarItem()
                    menuSecundario(sistema)
                }
                3 -> {
                    sistema.removeItem()
                    menuSecundario(sistema)
                }
                4 -> {
                    menuPagamento(sistema)
                }
                5 -> sair()
                else -> throw NumberFormatException()
            }
        } catch (e: NumberFormatException) {
            formatoInvalido()
            menuSecundario(sistema)
        } catch (e: IllegalArgumentException) {
            opcaoInvalida()
            menuSecundario(sistema)
        }
    }

    private fun menuPagamento(sistema: Sistema) {
        try {
            sistema.mostraCarrinhoDeCompras()

            println("Como deseja realizar o pagamento?\n" +
                    "[1] Cartão (débito, crédito ou vale refeição\n" +
                    "[2] Dinheiro\n" +
                    "[3] Sair do sistema")
            when(readln().toInt()) {
                1 -> {
                    println("Compra finalizada com sucesso! Boa refeição.")
                    menuNovaCompra(sistema)
                }
                2 -> {
                    sistema.calculaTroco(sistema.calculaValorTotal())
                    menuNovaCompra(sistema)
                }
                3 -> sair()
                else -> throw NumberFormatException()
            }
        } catch (e: NumberFormatException) {
            opcaoInvalida()
            menuPagamento(sistema)
        }

    }

    private fun menuNovaCompra(sistema: Sistema) {
        try {
            println("Deseja comprar novamente?\n" +
                    "[1] Sim | [2] Não")
            when(readln().toInt()) {
                1 -> menuInicial(sistema)
                2 -> sair()
                else -> throw NumberFormatException()
            }
        } catch (e: NumberFormatException) {
            formatoInvalido()
            menuNovaCompra(sistema)
        } catch (e: IllegalArgumentException) {
            opcaoInvalida()
            menuNovaCompra(sistema)
        }

    }

}