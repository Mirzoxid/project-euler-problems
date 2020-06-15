package problems

fun problem48() {
    var summ = mutableListOf(0)
    for (i in 1..1000) {
        val arr = powP48(i, i)
        summ = plusArrs(summ, arr)
    }
    summ.reversed().forEach { print(it) }
    println()
}

fun plusArrs(arr1: MutableList<Int>, arr2: MutableList<Int>): MutableList<Int> {
    val itArr = cloneArr(if (arr1.size > arr2.size) arr1 else arr2)
    val tmpArr = cloneArr(if (arr1.size <= arr2.size) arr1 else arr2)
    var d = 0
    for ((itIdx, _) in cloneArr(if (arr1.size > arr2.size) arr1 else arr2).withIndex()) {
        if (tmpArr.size > itIdx) {
            var n = itArr[itIdx] + tmpArr[itIdx]
            d = n / 10
            n %= 10
            itArr[itIdx] = n
        }
        var wI = itIdx + 1
        while (d > 0) {
            if (itArr.size > wI) {
                var n = itArr[wI] + d
                d = n / 10
                n %= 10
                itArr[wI] = n
            } else {
                itArr.add(d)
                d = 0
            }
            wI++
        }
    }
    return itArr
}

fun powP48(num: Int, pow: Int): MutableList<Int> {
    val bigInteger = mutableListOf(num)
    var dil = 0
    for (i in 1 until pow) {
        for ((index, item) in bigInteger.withIndex()) {
            var a = item * num
            while (dil > 0) {
                a += dil
                dil = 0
            }
            dil = a / 10
            bigInteger[index] = a % 10
        }
        while (dil > 0) {
            bigInteger.add(dil % 10)
            dil /= 10
        }
    }
    return bigInteger
}
