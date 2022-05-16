package menu

import produto.XBurger
import sistema.Sistema
import utilities.Utilities.Utilities.sair

class Menu {

    init {
        println("     Seja bem vindo(a) à   \n" +
                "*** LANCHONETE SIM CITY ***\n")

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
                2 -> {}
                3 -> sair()
                else -> throw NumberFormatException()
            }
        } catch (e: NumberFormatException) {
            println("Opção inválida! Tente novamente.")
            menuInicial(sistema)
        } catch (e: IllegalArgumentException) {
            println("Formato inválido, para escolher o item, você deve informar o número dele.")
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
                    //sistema.calculaTotal(xBurger)
                    menuSecundario(sistema)
                }
                2 -> {}
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
                2 -> {}
                3 -> sistema.removeItem()
                4 -> menuPagamento(sistema)
                5 -> sair()
                else -> throw NumberFormatException()
            }
        } catch (e: NumberFormatException) {
            println("Opção inválida! Tente novamente.")
            menuSecundario(sistema)
        } catch (e: IllegalArgumentException) {
            println("")
        }
    }

    private fun menuPagamento(sistema: Sistema) {
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
                sistema.calculaTroco()
                menuNovaCompra(sistema)
            }
            3 -> sair()
        }
    }
    private fun menuNovaCompra(sistema: Sistema) {
        println("Deseja comprar novamente?\n" +
                "[1] Sim | [2] Não")
        when(readln().toInt()) {
            1 -> menuInicial(sistema)
            2 -> sair()
        }
    }


}