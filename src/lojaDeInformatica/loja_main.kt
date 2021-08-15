package Exercicios


class Item(
    var numero_item: Int = 0,
    var descricao_item: String = "",
    var qtde_comprada: Int = 0,
    var preco_unitario: Double = 0.0
){

    init {
        if(this.preco_unitario < 0.0) {
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
