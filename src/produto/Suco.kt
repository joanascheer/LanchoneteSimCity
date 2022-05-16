package produto

class Suco(
    override var codigo: Int = 0,
    override var tipoDeProduto: String = "Suco",
    override var preco: Double = 6.0,
    override var quantidade: Int = 0,
) : Bebida(tipoDeProduto,codigo)