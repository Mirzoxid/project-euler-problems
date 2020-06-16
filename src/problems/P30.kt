package problems

fun solution30() {
    var rSumm = 0
    for (i in 10..1000000) {
        if (i == getPSum(i)){
            rSumm += i
        }
    }
    println(rSumm)
}

fun getPSum(i: Int): Int {
    var d = i
    var s = 0
    while (d > 0) {
        s += Math.pow(d % 10.0, 5.0).toInt()
        d /= 10
    }
    return s
}
