package problems

/**
 * The sum of the squares of the first ten natural numbers is,
 *
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 * */
fun main() {
    val mainNumber = 100
    var r1 = 0L
    var r2 = 0L
    for (i in 1..mainNumber) {
        r1 += i * i
        r2 += i
    }
    println((r2 * r2) - r1)
}