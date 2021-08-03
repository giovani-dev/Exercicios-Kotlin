package classes


enum class Sexo(val value: String){
    HOMEM("homem"),
    MULHER("mulher")
}


data class Pessoa(
    val idade: Int,
    val sexo: Sexo,
    val tempo_contribuicao: Int
)


class Aposentadoria{
    var pessoa: Pessoa

    constructor(pessoa: Pessoa){
        this.pessoa = pessoa
    }

    private fun is_tempo_contribuicao_valido(): Boolean {
        return this.pessoa.tempo_contribuicao >= 30
    }

    private fun is_homem_idoso_aposentado(): Boolean {
        return this.pessoa.sexo.value == "homem" && this.pessoa.idade >= 65 && this.is_tempo_contribuicao_valido()
    }

    private fun is_mulher_idosa_aposentada(): Boolean {
        return this.pessoa.sexo.value == "mulher" && this.pessoa.idade >= 60 && this.is_tempo_contribuicao_valido()
    }

    fun validar(): Boolean {
        return this.is_homem_idoso_aposentado() || this.is_mulher_idosa_aposentada()
    }
}


fun imprime_aposentadoria(pessoa: Pessoa): Unit {
    val aposentadoria: Aposentadoria = Aposentadoria(pessoa)
    println(aposentadoria.validar())
}

fun main() {
    val pessoa_idosa: Pessoa = Pessoa(60, Sexo.MULHER, 35)
    imprime_aposentadoria(pessoa_idosa)
}