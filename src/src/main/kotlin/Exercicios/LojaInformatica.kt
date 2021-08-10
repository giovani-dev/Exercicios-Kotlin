package Exercicios


class Item{
    val numero_item: Int
    val descricao_item: String
    val qtde_comprada: Int
    val preco_unitario: Double

    constructor(
        numero_item: Int,
        descricao_item: String,
        qtde_comprada: Int,
        preco_unitario: Double
    ){
        this.numero_item = numero_item
        this.descricao_item = descricao_item
        this.qtde_comprada = qtde_comprada
        if(preco_unitario < 0.0) {
            this.preco_unitario = 0.0
        } else{
            this.preco_unitario = preco_unitario
        }
    }

    fun total(): Double{
        return this.preco_unitario * this.qtde_comprada
    }
}


class Fatura{
    var itens: MutableList<Item>

    constructor(itens: MutableList<Item>){
        this.itens = itens
    }

    fun totalDaFatura(): Double {
        var total: Double = 0.0
        for(item in this.itens){
            total += item.total()
        }
        return total
    }
}

fun main() {
    var caneca_bic: Item = Item(152664965, "Caneca bic", 25, 1.5)
    var carro: Item = Item(152664965, "Carro", 25, 1.5)
    var itens: MutableList<Item> = mutableListOf<Item>()
    itens.add(caneca_bic)
    itens.add(carro)
    var fatura = Fatura(itens)
    println(fatura.totalDaFatura())
}
