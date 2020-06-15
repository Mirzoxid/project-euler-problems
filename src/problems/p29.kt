package problems

import kotlin.math.pow

fun problem29() {
    val arr = mutableListOf<MutableList<Int>>()
    for (i in 2..100){
        val itArr = mutableListOf(i)
        for (j in 2..100){
            multiplyBigInteger(itArr, i)
            arr.add(cloneArr(itArr))
        }
    }
    println(listToSet(arr).size)
}

fun multiplyBigInteger(bigInteger: MutableList<Int>, mult: Int) {
    var dil = 0
    for ((index, item) in bigInteger.withIndex()) {
        var a = item * mult
        while (dil > 0) {
            a += dil
            dil = 0
        }
        dil = a / 10
        bigInteger[index] = a % 10
    }
    while (dil>0){
        bigInteger.add(dil%10)
        dil /= 10
    }
}

fun listToSet(list: MutableList<MutableList<Int>>): MutableSet<MutableList<Int>>{
    val set = mutableSetOf<MutableList<Int>>()
    for (item in list){
        set.add(item)
    }
    return set
}
