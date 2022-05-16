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


    }
}