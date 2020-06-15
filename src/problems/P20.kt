package problems

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 * */

fun main() {
    val arr = mutableListOf(1)
    for (i in 1..1000){
        multiplyBN(arr, i)
    }
    var summ = 0
    arr.reversed().forEach { print(it) }
    println(summ)
}

fun multiplyBN(arr: MutableList<Int>, mNum: Int) {
    var dil = 0
    for ((index, i) in arr.withIndex()) {
        var a = i * mNum
        while (dil > 0) {
            a += dil
            dil = 0
        }
        dil = a / 10
        arr[index] = a % 10
    }
    while (dil>0){
        arr.add(dil%10)
        dil /= 10
    }
}
