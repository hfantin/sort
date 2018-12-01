import java.io.File
import java.text.NumberFormat
import java.util.*
import kotlin.math.pow

class Sort {

    private val nf by lazy { NumberFormat.getNumberInstance(Locale("pt", "BR")) }

    fun execute(potencia: Double) {
        val inicio = System.nanoTime()
        val total = 10.0.pow(potencia).toInt()
        println("ordena lista com tamanho $total (10^$potencia)")
        println("criando lista embaralhada...")
        val lista = listOf(0..total).flatMap { it }.shuffled()
        println("ordenando lista...")
        val ordenada = lista.sorted()
        println("tempo total=" + nf.format(System.nanoTime() - inicio) + " ns")
        gravarArquivo(ordenada)
    }

    fun gravarArquivo(data: List<Int>, fileName: String = "output.txt") =
        File(fileName).bufferedWriter().use { out -> data.forEach { out.write("$it ") } }
}

fun main(args: Array<String>) {
    println("Ordenador de listas - KOTLIN")
    val potencia = if (args.size == 0) 3.0 else args[0].toDouble()
    Sort().execute(potencia)
}

