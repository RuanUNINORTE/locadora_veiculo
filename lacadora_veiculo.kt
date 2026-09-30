class Veiculo(
    var modelo: String,
    var categoria: String,
    var diaria: Double
)

class Cliente(
    var nome: String
)

class Locacao(
    var veiculo: Veiculo,
    var cliente: Cliente,
    var dias: Int,
    var condutorAdicional: String?
)

fun main() {

    val carro = Veiculo("Fiat Argo", "Hatch", 100.0)
    val cliente = Cliente("Joao")

    val locacao = Locacao(
        carro,
        cliente,
        8,
        "Carlos"
    )

    var valorDiarias = 0.0

    // calculo das diarias
    for (i in 1..locacao.dias) {
        valorDiarias = valorDiarias + locacao.veiculo.diaria
    }

    // calculo do seguro
    val seguro = when (locacao.veiculo.categoria) {
        "Hatch" -> 50.0
        "Sedan" -> 70.0
        "SUV" -> 100.0
        else -> 0.0
    }

    // condutor adicional
    var taxaCondutor = 0.0

    if (locacao.condutorAdicional != null) {
        taxaCondutor = 30.0
    } else {
        taxaCondutor = 0.0
    }

    var subtotal = valorDiarias + seguro + taxaCondutor

    // desconto
    var desconto = 0.0

    if (locacao.dias > 7) {
        desconto = subtotal * 0.10
    } else {
        desconto = 0.0
    }

    var total = subtotal - desconto

    println("===== LOCADORA DE VEICULOS =====")
    println("Cliente: ${locacao.cliente.nome}")
    println("Veiculo: ${locacao.veiculo.modelo}")
    println("Categoria: ${locacao.veiculo.categoria}")
    println("Dias: ${locacao.dias}")
    println("Valor das diarias: R$ %.2f".format(valorDiarias))
    println("Seguro: R$ %.2f".format(seguro))

    if (locacao.condutorAdicional != null) {
        println("Condutor adicional: ${locacao.condutorAdicional}")
        println("Taxa do condutor: R$ %.2f".format(taxaCondutor))
    } else {
        println("Nao tem condutor adicional")
    }

    println("Desconto: R$ %.2f".format(desconto))
    println("Valor total: R$ %.2f".format(total))
}
