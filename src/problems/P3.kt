package problems

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 * */
fun main() {
    val mainNum = 600851475143L
    val decNum = Math.sqrt(mainNum * 1.0).toLong() + 1L
    var i = 2L
    val arr: MutableList<Long> = mutableListOf()
    while (decNum > i++) {
        if (mainNum % i == 0L) {
            arr.add(i)
        }
    }
    var tmp1 = 1L
    for (a in arr) {
        tmp1 = tmp1 * a
        if (tmp1 == mainNum) {
            println(a)
        }
    }
}