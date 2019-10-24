package problems

import kotlin.math.*

/**
 * The following iterative sequence is defined for the set of positive integers:
 *
 *   n → n/2 (n is even)
 *   n → 3n + 1 (n is odd)
 *
 *   Using the rule above and starting with 13, we generate the following sequence:
 *
 *   13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *   It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 *   Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 *   Which starting number, under one million, produces the longest chain?
 *
 *   NOTE: Once the chain starts the terms are allowed to go above one million.
 * */

fun main() {
    val mainNum = 1000000L
    println(getNumOverMillion(mainNum))
}

fun getNumOverMillion(mainNum: Long): Long {
    var i = 13L
    var count = 0L
    val res = arrayListOf<Long>()
    while (i < mainNum) {
        val tmp = getCount(i)
        if (tmp > count){
            count = tmp
            res.add(i)
        }
        i++
    }
    res.sort()
    return res.get(res.size - 1)
}

fun getCount(num: Long): Long {
    var i = 0L
    var a = num
    while (true) {
        i++
        if (a == 1L) break
        if (a % 2L == 0L) {
            a /= 2L
        } else {
            a = 3L * a + 1L
        }
    }
    return i
}



