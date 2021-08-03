package classes



class ContrutorPrimario1(text: String){
    val text: String = text
}


class ContrutorPrimario2(text: String){
    var text: String

    init {
        this.text = text
    }
}


class ConstrutorSecundario1{
    var child: MutableList<String> = mutableListOf()

    constructor(text: String){
        this.child.add(text)
    }

}

fun main(){
    var primario1 = ContrutorPrimario1("Primeiro")
    println("primario 1 ---> " + primario1.text)
    var primario2 = ContrutorPrimario2("Segundo")
    println("primario 2 ----> " + primario2.text)
    var secundario1 = ConstrutorSecundario1("asdmasdasd")
    println("Secundario 2 ----> " + secundario1.child)
}
