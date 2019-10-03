package problems

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 * */
fun main() {
    val mainNum = 10001
    println(getPrimeNumberByIndex(mainNum))
}

fun getPrimeNumberByIndex(mn: Int): Long {
    var i = 0
    var pn = 2L
    var lpn = 0L
    while (true) {
        if (i == mn) return lpn
        if (isPrime(pn)) {
            i++
            lpn = pn
        }
        pn++
    }
}

fun isPrime(n: Long): Boolean {
    for (i in 2..Math.sqrt(n * 1.0).toInt()) {
        if (n % i == 0L) {
            return false
        }
    }
    return true
}