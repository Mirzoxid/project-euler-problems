package problems

import kotlin.math.sqrt

fun solution35() {
    var summ = 0
    for (i in 2..1000000){
        if (isCircularPrime(i)) summ++
    }
    println(summ)
}

fun isCircularPrime(num: Int): Boolean {
    var n = num
    val arr = mutableListOf<Int>()
    val allVariant: MutableList<MutableList<Int>> = mutableListOf()
    while (n > 0) {
        arr.add(n % 10)
        n /= 10
    }
    circleNum(allVariant, arr)
    var tub = 0
    for (i in allVariant) {
        if (isTub(i.joinToString("").toInt())) {
            tub++
        }
    }
    return tub == allVariant.size
}

fun circleNum(allVariant: MutableList<MutableList<Int>>, arr: MutableList<Int>) {
    for (i in 0 until arr.size) allVariant.add(cloneArr(arr))
    for ((index, i) in arr.withIndex()) {
        for (j in 0 until arr.size) {
            allVariant[index][j] = arr[(j + index) % arr.size]
        }
    }
}

fun isTub(num: Int): Boolean {
    var isTub = true
    for (i in 2..(sqrt(num.toDouble())).toInt()) {
        if (num % i == 0) {
            isTub = false
            break
        }
    }
    return isTub
}
