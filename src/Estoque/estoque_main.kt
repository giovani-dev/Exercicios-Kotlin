package Exercicios.Estoque
import java.util.*


data class Produto(
    var nome: String,
    var codigo: String,
    var descricao: String
)


data class ProdutoEmEstoque(
    val produto: Produto,
    var quantidade: Int,
    val valor_compra: Double,
    val valor_venda: Double
)


class Movimentar(var estoque: Estoque) {
    var produto_escolhido: ProdutoEmEstoque? = null

    fun item(estoque_id: UUID): Movimentar {
        this.produto_escolhido = this.estoque.itens?.get(estoque_id)
        return this
    }

    fun repor(qtde: Int): Movimentar {
        this.produto_escolhido!!.quantidade += qtde
        return this
    }

    fun baixa(qtde: Int): Movimentar {
        this.produto_escolhido!!.quantidade -= qtde
        return this
    }
}


class Estoque(
    val exported_estoque: MutableMap<UUID, ProdutoEmEstoque>? = mutableMapOf<UUID, ProdutoEmEstoque>()
){
    var itens: MutableMap<UUID, ProdutoEmEstoque>? = this.exported_estoque
    var movimentar: Movimentar = Movimentar(this)

    fun listar() {
        val produtoEstoqueList: List<UUID> = this.itens!!.keys.toList()
        for (produto in produtoEstoqueList) {
            println("------------------------------------------------------------------------------")
            println("-> Nome do Produto: " + this.itens?.get(produto)?.produto?.nome)
            println("-> Codigo do Produto: " + this.itens?.get(produto)?.produto?.codigo)
            println("-> Descricao do Produto: " + this.itens?.get(produto)?.produto?.descricao)
            println("-> Quantidade: " + this.itens?.get(produto)?.quantidade)
            println("-> Valor de compra: " + this.itens?.get(produto)?.valor_compra)
            println("-> Valor de venda: " + this.itens?.get(produto)?.valor_venda)
            println("\n")
        }
    }

    fun adicionar(
        produto: Produto,
        quantidade: Int,
        valor_compra: Double,
        valor_venda: Double
    ) {
        val emEstoque = ProdutoEmEstoque(
            produto = produto,
            quantidade = quantidade,
            valor_compra = valor_compra,
            valor_venda = valor_venda
        )
        this.itens?.put(UUID.randomUUID(), emEstoque)
    }

}


fun main() {
    val to_get_id: UUID = UUID.randomUUID()
    val itens: MutableMap<UUID, ProdutoEmEstoque> = mutableMapOf<UUID, ProdutoEmEstoque>(
        to_get_id to ProdutoEmEstoque(
            produto= Produto(
                nome ="Cabo usb tipo c macho",
                codigo ="1563sdas56",
                descricao ="blablabla"
            ),
            quantidade = 15,
            valor_compra = 10.15,
            valor_venda = 75.48
        ),
        UUID.randomUUID() to ProdutoEmEstoque(
            produto= Produto(
                nome = "Notebook xiomi",
                codigo = "16532q6",
                descricao = "blablabla to bla"
            ),
            quantidade = 5,
            valor_compra = 15.45,
            valor_venda = 155.99
        )
    )
    val estoque = Estoque(itens)
    estoque.movimentar.item(estoque_id = to_get_id)
        .repor(qtde = 15)
        .baixa(qtde = 1)
    estoque.adicionar(
        produto = Produto(
            nome = "NoteBook accer xpt1910",
            codigo = "bla290188",
            descricao = "blablablablablablablablablablablablablab"
        ),
        quantidade = 99999999999.toInt(),
        valor_compra = 14200.58,
        valor_venda = 50522.85
    )
    estoque.listar()
}