package produto

open class Lanche(
    override var tipoDeProduto: String,
    override var codigo: Int = 0,
) : Produto()