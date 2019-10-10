package problems

import kotlin.math.sqrt

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * */
fun main() {
    val mainNum = 500000
    val sqrList = getABC(mainNum)
    val pythList = getPythList(sqrList)
    println(getResult(pythList, 1000))
}

fun getABC(mainNum: Int): MutableList<Int> {
    val myList = mutableListOf<Int>()
    for (i in mainNum - 1 downTo 2) {
        if (chechPyth(i)) {
            myList.add(i)
        }
    }
    return myList
}

fun getPythList(sqrList: MutableList<Int>): MutableList<MutableList<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    for ((indexi, i) in sqrList.withIndex()) {
        for ((indexj, j) in sqrList.withIndex()) {
            val tmpMR = mutableListOf<Int>()
            for ((indexc, c) in sqrList.withIndex()) {
                if (indexj in (indexi + 1) until indexc) {
                    if (i == j + c) {
                        tmpMR.add(i)
                        tmpMR.add(j)
                        tmpMR.add(c)
                    }
                }
            }
            if (tmpMR.isNotEmpty())
                res.add(tmpMR)
        }
    }
    return res
}

fun chechPyth(num: Int): Boolean {
    val a = sqrt(num * 1.0).toInt()
    if (a * a == num) {
        return true
    }
    return false
}

fun getResult(pythList: MutableList<MutableList<Int>>, summ: Int): Long {
    var r = 1L
    print(pythList)
    println()
    for (it in pythList) {
        var s = 0
        for (i in it) {
            s += sqrt(i * 1.0).toInt()
        }
        if (s == summ) {
            for (i in it) {
                r*=sqrt(i * 1.0).toInt()
            }
        }
    }
    return r
}
