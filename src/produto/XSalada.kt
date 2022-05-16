package produto

class XSalada(
    override var codigo: Int = 0,
    override var tipoDeProduto: String = "Hamburguer",
    override var preco: Double = 12.0,
    override var quantidade: Int = 0,
) : Lanche(tipoDeProduto, codigo)