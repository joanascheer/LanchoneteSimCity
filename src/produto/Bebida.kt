package produto

open class Bebida(
    override var tipoDeProduto: String,
    override var codigo: Int = 0,
) : Produto()