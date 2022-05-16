package produto

class Refrigerante (
    override var codigo: Int = 0,
    override var tipoDeProduto: String = "Refrigerante",
    override var preco: Double = 8.0,
    override var quantidade: Int = 0,
    ) : Bebida(tipoDeProduto,codigo)