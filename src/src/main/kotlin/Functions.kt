

fun factorial(n: Int): Long{
    return if(n == 0 || n == 1){
        n.toLong()
    } else{
        n * factorial(n-1)
    }
}


fun maiorDeTres(
    n1: Int,
    n2: Int,
    n3: Int
): Int{
    return if(n1 > n2 && n1 > n3){
        n1
    } else if(n2 > n1 && n2 > n3){
        n2
    } else{
        n3
    }
}


fun igualdedeDeString(
    str1: String,
    str2: String
): Boolean = (str1 == str2)


fun numeroPar(n: Int): Boolean = (n%2 == 0)

fun main(){
    println("Fatorial de 5: " + factorial(5))
    println("1) Maior de 3 (5 - 10 - 5): " + maiorDeTres(5,10,5))
    println("1) Maior de 3 (5 - 5 - 5): " + maiorDeTres(5,5,5))
    println("2) String igual (cidade - cidade): " + igualdedeDeString("cidade", "cidade"))
    println("2) String igual (leste - cidade): " + igualdedeDeString("leste", "cidade"))
    println("3) E um numero par? (4): " + numeroPar(4))
    println("3) E um numero par? (5): " + numeroPar(5))
}