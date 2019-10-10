package problems

import kotlin.math.*

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 * */
fun main() {
    val mainNum = 2000000
    println(summPrimeNumbers(mainNum))
}

fun summPrimeNumbers(mainNum: Int): Long {
    var summ = 0L
    val numbersList = BooleanArray(mainNum) { true }
    val primeList = getPrimeList(numbersList)
    for ((index, i) in primeList.withIndex()) {
        if (index >= 2 && i)
            summ += index
    }
    return summ
}

fun getPrimeList(numbersList: BooleanArray): BooleanArray {
    val primeList = arrayListOf<Int>()
    for ((index, i) in numbersList.withIndex()) {
        if (index < 2) continue
        var j = index + index
        while (j < numbersList.size) {
            numbersList[j] = false
            j += index
        }
    }
    return numbersList
}

fun getListOfNumber(mainNum: Int): ArrayList<Int> {
    val list = arrayListOf<Int>()
    for (i in 2..mainNum) {
        list.add(i)
    }
    return list
}