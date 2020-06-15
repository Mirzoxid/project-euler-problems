package problems

/**
 *   215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 *   What is the sum of the digits of the number 21000?
 * */

fun main() {
    var summ = 0
    for (i in pow(2, 15)){
        summ += i
    }
    println(summ)
}


fun pow(num: Int, deg: Int): MutableList<Int>{
    val arr = mutableListOf<Int>()
    arr.add(1)
    for (i in 0 until deg) {
        var ortiqcha = 0
        val size = arr.size
        for (idx in 0 until size) {
            var mult = arr[idx] * num
            if (ortiqcha > 0) {
                mult += ortiqcha
                ortiqcha = 0
            }
            arr[idx] = mult % 10
            ortiqcha = mult / 10
            if (ortiqcha > 0 && idx == size - 1) {
                arr.add(ortiqcha)
                ortiqcha = 0
            }
        }
    }
    return arr.asReversed()
}
