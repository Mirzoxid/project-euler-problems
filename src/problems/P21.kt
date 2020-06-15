package problems

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
 * */
fun executeProblem21(): Int {
    var summ = 0
    val map = mutableMapOf<Int, Int>()
    for (i in 4..10000) {
        map[i] = getSummDevesors(i)
    }
    map.forEach { (k, v) ->
        if (k != v && map[k] == v && map[v] == k) {
            summ += v
        }
    }
    return summ
}

fun getSummDevesors(num: Int): Int {
    var summ = 0
    for (i in 1..num / 2 + 1) {
        if (num % i == 0) {
            summ += i
        }
    }
    return summ
}
