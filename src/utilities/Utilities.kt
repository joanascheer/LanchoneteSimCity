package utilities

import kotlin.system.exitProcess

class Utilities {

    companion object Utilities {
        fun sucesso() {
            println("Processo realizado com sucesso!\n")
        }

        fun sair() {
            println("Obrigado(a) pela sua compra! Até mais!\n")
            exitProcess(0)
        }

        fun boasVindas() {
            println("     Seja bem vindo(a) à   \n" +
                    "*** LANCHONETE SIM CITY ***\n")
        }

        fun opcaoInvalida() {
            println("Opção inválida, tente novamente!")
        }

        fun formatoInvalido() {
            println("Formato inválido, para escolher o item, você deve informar o número dele.")
        }

        fun numeroNegativo() {
            println("O número informado deve ser positivo.")
        }

        fun digitarCodigo() {
            println("Você deve digitar um código válido para continuar.")
        }
    }
}