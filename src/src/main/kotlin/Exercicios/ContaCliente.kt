package Exemplos.exercicio_4_agosto_2021
import java.time.LocalDateTime


data class Cliente(
    val nome: String,
    val sobreNome: String
)


data class Conta(
    val numero: Int,
    var saldo: Double,
    val titular: Cliente
)


class Operacoes{
    var conta: Conta

    constructor(conta: Conta){
        this.conta = conta
    }

    fun depositar(valor: Double): Conta{
        var nomeCliente: String = this.conta.titular.nome + " " + this.conta.titular.sobreNome
        var dataHora = LocalDateTime.now()
        println("[$dataHora] $nomeCliente - Realizando deposito de $valor Reais.")
        this.conta.saldo += valor
        var saldo: Double = this.conta.saldo
        println("[$dataHora] $nomeCliente - Saldo total de $saldo Reais.\n")
        return this.conta
    }

    fun saque(valor: Double): Conta{
        var saldo: Double? = null
        var nomeCliente: String = this.conta.titular.nome + " " + this.conta.titular.sobreNome
        var dataHora = LocalDateTime.now()

        println("[$dataHora] $nomeCliente - Realizando saque de $valor Reais.")
        if(valor <= this.conta.saldo){
            this.conta.saldo -= valor
            saldo = this.conta.saldo
            println("[$dataHora] $nomeCliente - Saldo total de $saldo Reais.\n")
        } else {
            saldo = this.conta.saldo
            println("[$dataHora] $nomeCliente - Saldo insuficiente.")
            println("[$dataHora] $nomeCliente - Saldo total de $saldo Reais.\n")
        }
        return this.conta
    }
}

fun main() {
    val clienteGiovani: Cliente = Cliente("Giovani", "Liskoski Zanini")
    val contaGiovani: Conta = Conta(25469, 0.0, clienteGiovani)
    var opGiovani: Operacoes = Operacoes(contaGiovani)
    opGiovani.depositar(15.0)
    opGiovani.depositar(15.0)
    opGiovani.saque(15.0)
    opGiovani.saque(45.0)

    val clienteJoao: Cliente = Cliente("Joao", "Andromeda")
    val contaJoao: Conta = Conta(1236598, 22.4369, clienteJoao)
    var opJoao: Operacoes = Operacoes(contaJoao)
    opJoao.depositar(15.0)
    opJoao.depositar(15.0)
    opJoao.saque(15.0)
    opJoao.saque(45.0)
}
