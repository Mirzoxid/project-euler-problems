package problems

/**
 *   If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 *   If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 *
 *
 *   NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 * */

val generateNumberObjects = hashMapOf(
        1 to "one",
        2 to "two",
        3 to "three",
        4 to "four",
        5 to "five",
        6 to "six",
        7 to "seven",
        8 to "eight",
        9 to "nine",
        10 to "ten",
        11 to "eleven",
        12 to "twelve",
        13 to "thirteen",
        14 to "fourteen",
        15 to "fifteen",
        16 to "sixteen",
        17 to "seventeen",
        18 to "eighteen",
        19 to "nineteen",
        20 to "twenty",
        30 to "thirty",
        40 to "forty",
        50 to "fifty",
        60 to "sixty",
        70 to "seventy",
        80 to "eighty",
        90 to "ninety",
        100 to "hundred",
        1000 to "thousand",
        0 to "and",
        -1 to "-"
)

fun main() {
    var summ = 0
    for (i in generateIncNumberNames(1000)) {
        summ += i.replace("-", "").replace(" ", "").length
    }
    println(summ)
}

fun generateIncNumberNames(number: Int): MutableList<String> {
    val arr = mutableListOf<String>()
    for (i in 1..number) {
        var loadNum = i
        var str = ""
        if (loadNum / 1000 >= 1) {
            str += getStrFromNumberKey(loadNum / 1000) + " " + getStrFromNumberKey(1000)
        }
        loadNum %= 1000
        if (loadNum / 100 >= 1) {
            str += getStrFromNumberKey(loadNum / 100) + " " + getStrFromNumberKey(100)
        }
        loadNum %= 100
        if (loadNum / 10 > 1) {
            if (str != "") str += " " + getStrFromNumberKey(0)
            str += " " + getStrFromNumberKey(loadNum / 10 * 10)
            if (loadNum % 10 > 0)
                str += "-" + getStrFromNumberKey(loadNum % 10)
        } else if (loadNum / 10 == 1) {
            if (str != "") str += " " + getStrFromNumberKey(0) + " "
            str += getStrFromNumberKey(loadNum)
        } else {
            if (loadNum % 10 > 0){
                if (str != "") str += " " + getStrFromNumberKey(0)
                    str += " " + getStrFromNumberKey(loadNum % 10)
            }

        }
        arr.add(str)
    }
    return arr
}

fun getStrFromNumberKey(key: Int): String? {
    return generateNumberObjects[key]
}
