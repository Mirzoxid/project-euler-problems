package problems

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * */
fun main() {
    val a = 999
    val b = 999
    var maxPol = 0

    var i = 100
    var j = 100

    while (i <= a) {
        while (j <= b) {
            if (isPolindrom((i * j).toString().toCharArray())) {
                if (maxPol < (i * j))
                    maxPol = i * j
            }
            j++
        }
        i++
        j = 100
    }
    println(maxPol)
}

fun isPolindrom(a: CharArray): Boolean {
    var l = 0
    var r = a.size - 1
    while (r > l) {
        if (a.get(l++) != a.get(r--)) return false
    }
    return true
}