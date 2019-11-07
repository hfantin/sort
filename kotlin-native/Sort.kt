import kotlin.math.pow
import kotlin.system.*
import platform.posix.*

class Sort {

    fun execute(potencia: Double) {
        val total = 10.0.pow(potencia).toInt()
        println("ordena lista com tamanho $total (10^$potencia)")
        var ordenada: List<Int> = listOf()
        val tempo = measureTimeMillis {
            ordenada = createList(total)
        }
        println("tempo total= $tempo ms")
		gravar(ordenada);
    }

    fun createList(total: Int): List<Int>{
        println("criando lista embaralhada...")
        val lista = listOf(0..total).flatMap { it }.shuffled()
        println("ordenando lista...")
        return lista.sorted()
    }
}

fun gravar(data: List<Int>, nome: String="output.txt") {
    println("gravando $nome")
    val file = fopen(nome, "wt")
    if (file == null) throw Error("Cannot write file '$nome'")
    try {
		data.forEach { fputs("$it ", file) }
    } finally {
        fclose(file)
    }
}

fun main(args: Array<String>) {
    println("Ordenador de listas - KOTLIN/NATIVE")
    val potencia = if (args.size == 0) 3.0 else args[0].toDouble()
    Sort().execute(potencia)
}

